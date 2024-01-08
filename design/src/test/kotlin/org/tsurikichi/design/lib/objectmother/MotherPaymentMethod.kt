package org.tsurikichi.design.lib.objectmother

import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentMethod
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentMethodCode

object MotherPaymentMethod {

    fun default(): PaymentMethod {
        return PaymentMethod.create(
            paymentMethodCode = PaymentMethodCode("1"),
            paymentAmount = PaymentAmount(1_000)
        )
    }
}
