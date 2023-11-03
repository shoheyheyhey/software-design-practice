package org.tsurikichi.design.ddd.practice1.presentation.payment

import java.time.LocalDateTime

data class PaymentCreateRequest(
    val receiptNumber: String,
    val paymentDateTime: LocalDateTime,
    val usePoints: Int?,
    val memberCode: String,
    val companyCode: String,
    val shopCode: String,
    val couponCode: String?,
    val paymentPurchases: List<PaymentPurchase>,
    val paymentMethods: List<PaymentMethod>
) {
    data class PaymentPurchase(
        val memberCompanyGoodsCode: String,
        val quantity: Int,
        val price: Int
    )

    data class PaymentMethod(
        val paymentMethodCode: String,
        val paymentMethodAmount: Int
    )
}
