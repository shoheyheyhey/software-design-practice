package org.tsurikichi.design.ddd.builder

import nu.studer.sample.Tables.PAYMENT_METHOD_DETAIL
import org.jooq.DSLContext
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentMethod
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentMethodCode
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

class BuilderPaymentMethod(
    private val receiptNumber: ReceiptNumber = ReceiptNumber("1"),
    private val paymentMethodCode: PaymentMethodCode = PaymentMethodCode("1"),
    private val paymentAmount: PaymentAmount = PaymentAmount(1_000),
    private val grantPoint: Int = 50
) {
    fun build(): PaymentMethod = PaymentMethod.create(
        paymentMethodCode = paymentMethodCode,
        paymentAmount = paymentAmount
    )

    fun insert(dslContext: DSLContext) {
        dslContext.insertInto(PAYMENT_METHOD_DETAIL, PAYMENT_METHOD_DETAIL.RECEIPT_NUMBER, PAYMENT_METHOD_DETAIL.PAYMENT_METHOD_CODE, PAYMENT_METHOD_DETAIL.PAYMENT_AMOUNT, PAYMENT_METHOD_DETAIL.GIVEN_POINT)
            .values(receiptNumber.value.toInt(), paymentMethodCode.value.toInt(), paymentAmount.value, grantPoint)
            .execute()
    }
}
