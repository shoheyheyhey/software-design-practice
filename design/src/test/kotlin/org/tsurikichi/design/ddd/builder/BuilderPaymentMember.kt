package org.tsurikichi.design.ddd.builder

import nu.studer.sample.tables.Member.MEMBER
import org.jooq.DSLContext
import org.tsurikichi.design.ddd.practice1.domain.member.PaymentMember
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point

class BuilderPaymentMember(
    private val memberCode: MemberCode = MemberCode("1"),
    private val memberName: String = "てすと　たろう",
    private val remainingPoints: Point = Point(1_000)
) {
    fun build(): PaymentMember = PaymentMember(
        memberCode = memberCode,
        remainingPoints = remainingPoints
    )

    fun insert(dslContext: DSLContext) {
        dslContext.insertInto(MEMBER, MEMBER.MEMBER_CODE, MEMBER.MEMBER_NAME, MEMBER.POINT_BALANCE)
            .values(memberCode.value.toInt(), memberName, remainingPoints.value)
            .execute()
    }
}
