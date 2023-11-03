package org.tsurikichi.design.ddd.practice1.domain.payment

import org.tsurikichi.design.ddd.practice1.domain.member.PaymentMember
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCompanyCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDateTime
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import java.time.LocalDateTime

class Payment(
    val receiptNumber: ReceiptNumber,
    private val paymentDateTime: PaymentDateTime,
    private val paymentMember: PaymentMember,
    private val companyCode: MemberCompanyCode,
    private val shopCode: ShopCode,
    private val couponCode: CouponCode?,
    private val paymentMethod: List<PaymentMethod>,
    private val paymentPurchase: List<PaymentPurchase>
) {
    init {
        if (paymentMethod.sumOf { it.paymentAmount.value } != paymentPurchase.sumOf { it.goodsPrice.value }) throw IllegalArgumentException("支払金額と購入金額が不整合です")
    }

    fun getDataModel(): PaymentDataModel {
        return PaymentDataModel(
            receiptNumber = receiptNumber.value.toInt(),
            paymentDate = paymentDateTime.value,
            paymentMember = paymentMember.getDataModel(),
            companyCode = companyCode.value.toInt(),
            shopCode = shopCode.value.toInt(),
            couponCode = couponCode?.value?.toInt(),
            paymentMethod = paymentMethod.map { it.getDataModel() },
            paymentPurchase = paymentPurchase.map { it.getDataModel() }
        )
    }

    data class PaymentDataModel(
        val receiptNumber: Int,
        val paymentDate: LocalDateTime,
        val paymentMember: PaymentMember.PaymentMemberDataModel,
        val companyCode: Int,
        val shopCode: Int,
        val couponCode: Int?,
        val paymentMethod: List<PaymentMethod.PaymentMethodDataModel>,
        val paymentPurchase: List<PaymentPurchase.PaymentPurchaseDataModel>
    )
}
