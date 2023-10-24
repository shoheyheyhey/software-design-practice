package org.tsurikichi.design.ddd_practice1.domain.member

import org.tsurikichi.design.ddd_practice1.domain.share.MemberCode

interface IPaymentMemberRepository {
    fun findBy(memberCode: MemberCode): PaymentMember
    fun update(paymentMember: PaymentMember)

}
