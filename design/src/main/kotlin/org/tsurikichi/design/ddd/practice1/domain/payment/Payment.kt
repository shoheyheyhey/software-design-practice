package org.tsurikichi.design.ddd.practice1.domain.payment

import org.tsurikichi.design.ddd.practice1.domain.member.PaymentMember
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDate
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode

class Payment(
    val receiptNumber: ReceiptNumber,
    private val paymentDate: PaymentDate,
    private val paymentAmount: PaymentAmount,
    private val paymentMember: PaymentMember,
    private val shopCode: ShopCode,
    private val couponCode: CouponCode?,
    private val paymentMethod: List<PaymentMethod>,
    private val paymentPurchase: List<PaymentPurchase>
) {
    init {
        if (paymentAmount.value != paymentMethod.sumOf { it.paymentAmount.value }) throw IllegalArgumentException("支払金額が不正です")
        if (paymentAmount.value != paymentPurchase.sumOf { it.goodsPrice.value }) throw IllegalArgumentException("支払金額が不正です")
    }
}
