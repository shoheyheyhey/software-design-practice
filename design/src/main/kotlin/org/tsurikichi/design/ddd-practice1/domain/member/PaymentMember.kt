package org.tsurikichi.design.`ddd-practice1`.domain.member

import org.tsurikichi.design.`ddd-practice1`.domain.share.MemberCode
import org.tsurikichi.design.`ddd-practice1`.domain.share.Point

class PaymentMember(
    val memberCode: MemberCode,
    private val remainingPoints: Point
) {

    fun usePoints(point: Point): PaymentMember {
        if (remainingPoints.value < point.value) throw IllegalArgumentException("ポイントが不足しています")
        return PaymentMember(memberCode, Point(remainingPoints.value - point.value))
    }
}
