package org.tsurikichi.design.ddd.practice1.infrastructure

import nu.studer.sample.tables.Member.MEMBER
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.tsurikichi.design.ddd.practice1.domain.member.IPaymentMemberRepository
import org.tsurikichi.design.ddd.practice1.domain.member.PaymentMember
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point

@Repository
class PaymentMemberRepository(private val dslContext: DSLContext) : IPaymentMemberRepository {
    override fun findBy(memberCode: MemberCode): PaymentMember {
        val record = dslContext.selectFrom(MEMBER)
            .where(MEMBER.MEMBER_CODE.eq(memberCode.value.toInt()))
            .fetchOne() ?: throw IllegalArgumentException("会員が存在しません")

        return PaymentMember(
            memberCode = MemberCode(record[MEMBER.MEMBER_CODE].toString()),
            remainingPoints = Point(record[MEMBER.POINT_BALANCE])
        )
    }
}
