package org.tsurikichi.design.lib.fixtures.extension

import org.tsurikichi.design.lib.fixtures.PaymentFixture
import org.tsurikichi.design.lib.objectmother.MotherPaymentMember
import java.time.LocalDateTime

fun PaymentFixture.default(): PaymentFixture {
    return PaymentFixture(
        receipt_number = 1,
        member_code = MotherPaymentMember.default().memberCode.value.toInt(),
        payment_date_time = LocalDateTime.now(),
        affiliate_company_code = 1,
        store_code = 1,
        used_point = MotherPaymentMember.default().getDataModel().usePoints
    )
}
