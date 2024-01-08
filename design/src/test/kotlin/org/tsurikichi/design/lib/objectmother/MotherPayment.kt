package org.tsurikichi.design.lib.objectmother

import org.tsurikichi.design.ddd.practice1.domain.payment.Payment
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCompanyCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDateTime
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import java.time.LocalDateTime

object MotherPayment {

    fun default(): Payment {
        return Payment(
            receiptNumber = ReceiptNumber("1"),
            paymentDateTime = PaymentDateTime(LocalDateTime.now()),
            companyCode = MemberCompanyCode("1"),
            shopCode = ShopCode("1"),
            paymentMember = MotherPaymentMember.default(),
            couponCode = null,
            paymentMethod = listOf(MotherPaymentMethod.default()),
            paymentPurchase = listOf(MotherPaymentPurchase.default())
        )
    }
}
