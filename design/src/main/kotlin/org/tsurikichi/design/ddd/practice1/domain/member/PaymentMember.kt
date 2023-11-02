package org.tsurikichi.design.ddd.practice1.domain.member

import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point

class PaymentMember(
    val memberCode: MemberCode,
    private val usePoints: Point = Point(0),
    private val remainingPoints: Point
) {

    fun usePoints(point: Point): PaymentMember {
        if (remainingPoints.value < point.value) throw IllegalArgumentException("ポイントが不足しています")
        return PaymentMember(memberCode, point, Point(remainingPoints.value - point.value))
    }

    fun getDataModel(): PaymentMemberDataModel {
        return PaymentMemberDataModel(
            memberCode = memberCode.value.toInt(),
            usePoints = usePoints.value,
            remainingPoints = remainingPoints.value
        )
    }

    data class PaymentMemberDataModel(
        val memberCode: Int,
        val usePoints: Int,
        val remainingPoints: Int
    )
}
