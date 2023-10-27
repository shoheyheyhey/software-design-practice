package org.tsurikichi.design.ddd.mother

import org.tsurikichi.design.ddd.practice1.domain.member.PaymentMember
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point

object MotherPaymentMember {

    fun default(): PaymentMember {
        return PaymentMember(
            memberCode = MemberCode("1"),
            remainingPoints = Point(1_000)
        )
    }
}
