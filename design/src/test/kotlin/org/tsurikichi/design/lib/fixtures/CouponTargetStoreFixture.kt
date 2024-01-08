package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class CouponTargetStoreFixture(
    val coupon_code: Int? = null,
    val affiliate_company_code: Int? = null,
    val store_code: Int? = null
)

fun DbSetupBuilder.insertCouponTargetStoreFixture(f: CouponTargetStoreFixture) {
    insertInto("coupon_target_store") {
        mappedValues(
            "coupon_code" to f.coupon_code,
            "affiliate_company_code" to f.affiliate_company_code,
            "store_code" to f.store_code
        )
    }
}

fun DbSetupBuilder.insert(f: CouponTargetStoreFixture) {
    insertCouponTargetStoreFixture(f)
}
