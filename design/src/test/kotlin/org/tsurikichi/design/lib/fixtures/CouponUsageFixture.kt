package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class CouponUsageFixture(
    val coupon_code: Int? = null,
    val receipt_number: Int? = null
)

fun DbSetupBuilder.insertCouponUsageFixture(f: CouponUsageFixture) {
    insertInto("coupon_usage") {
        mappedValues(
            "coupon_code" to f.coupon_code,
            "receipt_number" to f.receipt_number
        )
    }
}

fun DbSetupBuilder.insert(f: CouponUsageFixture) {
    insertCouponUsageFixture(f)
}
