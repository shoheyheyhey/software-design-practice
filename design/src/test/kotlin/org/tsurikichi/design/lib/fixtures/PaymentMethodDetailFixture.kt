package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class PaymentMethodDetailFixture(
    val receipt_number: Int? = null,
    val payment_method_code: Int? = null,
    val payment_amount: Int? = null,
    val given_point: Int? = null
)

fun DbSetupBuilder.insertPaymentMethodDetailFixture(f: PaymentMethodDetailFixture) {
    insertInto("payment_method_detail") {
        mappedValues(
            "receipt_number" to f.receipt_number,
            "payment_method_code" to f.payment_method_code,
            "payment_amount" to f.payment_amount,
            "given_point" to f.given_point
        )
    }
}

fun DbSetupBuilder.insert(f: PaymentMethodDetailFixture) {
    insertPaymentMethodDetailFixture(f)
}
