package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class PaymentMethodFixture(
    val payment_method_code: Int = 0,
    val payment_method_name: String = "",
    val point_setting_code: Int? = null
)

fun DbSetupBuilder.insertPaymentMethodFixture(f: PaymentMethodFixture) {
    insertInto("payment_method") {
        mappedValues(
            "payment_method_code" to f.payment_method_code,
            "payment_method_name" to f.payment_method_name,
            "point_setting_code" to f.point_setting_code
        )
    }
}

fun DbSetupBuilder.insert(f: PaymentMethodFixture) {
    insertPaymentMethodFixture(f)
}
