package org.tsurikichi.design.lib.fixtures.extension

import org.tsurikichi.design.lib.fixtures.PaymentFixture
import org.tsurikichi.design.lib.objectmother.MotherPayment
import org.tsurikichi.design.lib.objectmother.MotherPaymentMember
import java.time.LocalDateTime

fun PaymentFixture.default(): PaymentFixture {
    val motherPayment = MotherPayment.default()
    val motherPaymentMember = MotherPaymentMember.default()

    return PaymentFixture(
        receipt_number = motherPayment.receiptNumber.value.toInt(),
        member_code = motherPaymentMember.memberCode.value.toInt(),
        payment_date_time = LocalDateTime.now(),
        affiliate_company_code = motherPayment.getDataModel().companyCode,
        store_code = motherPayment.getDataModel().shopCode,
        used_point = motherPaymentMember.getDataModel().usePoints
    )
}
