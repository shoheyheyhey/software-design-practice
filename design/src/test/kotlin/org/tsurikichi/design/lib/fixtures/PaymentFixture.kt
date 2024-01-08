package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDateTime

data class PaymentFixture(
    val receipt_number: Int = 0,
    val member_code: Int? = null,
    val affiliate_company_code: Int? = null,
    val store_code: Int? = null,
    val payment_date_time: LocalDateTime? = null,
    val used_point: Int? = null
)

fun DbSetupBuilder.insertPaymentFixture(f: PaymentFixture) {
    insertInto("payment") {
        mappedValues(
            "receipt_number" to f.receipt_number,
            "member_code" to f.member_code,
            "affiliate_company_code" to f.affiliate_company_code,
            "store_code" to f.store_code,
            "payment_date_time" to f.payment_date_time,
            "used_point" to f.used_point
        )
    }
}

fun DbSetupBuilder.insert(f: PaymentFixture) {
    insertPaymentFixture(f)
}
