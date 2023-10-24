package org.tsurikichi.design.ddd.practice1.presentation.payment

import java.time.LocalDate

data class PaymentCreateRequest(
    val receiptNumber: String,
    val paymentDate: LocalDate,
    val paymentAmount: Int,
    val usePoints: Int?,
    val memberCode: String,
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
