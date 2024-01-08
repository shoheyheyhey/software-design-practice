package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class CouponTargetProductFixture(
    val coupon_code: Int? = null,
    val affiliate_company_code: Int? = null,
    val affiliate_product_code: Int? = null
)

fun DbSetupBuilder.insertCouponTargetProductFixture(f: CouponTargetProductFixture) {
    insertInto("coupon_target_product") {
        mappedValues(
            "coupon_code" to f.coupon_code,
            "affiliate_company_code" to f.affiliate_company_code,
            "affiliate_product_code" to f.affiliate_product_code
        )
    }
}

fun DbSetupBuilder.insert(f: CouponTargetProductFixture) {
    insertCouponTargetProductFixture(f)
}
