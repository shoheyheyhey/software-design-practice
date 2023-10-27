package org.tsurikichi.design.ddd.mother

import org.tsurikichi.design.ddd.practice1.domain.payment.Payment
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDate
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import java.time.LocalDate

object MotherPayment {

    fun default(): Payment {
        return Payment(
            receiptNumber = ReceiptNumber("1"),
            paymentDate = PaymentDate(LocalDate.now()),
            paymentAmount = PaymentAmount(1_000),
            usePoints = null,
            shopCode = ShopCode("1"),
            paymentMember = MotherPaymentMember.default(),
            couponCode = null,
            paymentMethod = listOf(MotherPaymentMethod.default()),
            paymentPurchase = listOf(MotherPaymentPurchase.default())
        )
    }
}
