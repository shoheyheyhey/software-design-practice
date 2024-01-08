package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDate

data class CouponSettingFixture(
    val coupon_code: Int = 0,
    val coupon_name: String = "",
    val planning_affiliate_company_code: Int? = null,
    val distribution_start_date: LocalDate? = null,
    val distribution_end_date: LocalDate? = null,
    val usage_start_date: LocalDate? = null,
    val usage_end_date: LocalDate? = null,
    val point_rate: Double? = null,
    val distribution_limit: Int? = null
)

fun DbSetupBuilder.insertCouponSettingFixture(f: CouponSettingFixture) {
    insertInto("coupon_setting") {
        mappedValues(
            "coupon_code" to f.coupon_code,
            "coupon_name" to f.coupon_name,
            "planning_affiliate_company_code" to f.planning_affiliate_company_code,
            "distribution_start_date" to f.distribution_start_date,
            "distribution_end_date" to f.distribution_end_date,
            "usage_start_date" to f.usage_start_date,
            "usage_end_date" to f.usage_end_date,
            "point_rate" to f.point_rate,
            "distribution_limit" to f.distribution_limit
        )
    }
}

fun DbSetupBuilder.insert(f: CouponSettingFixture) {
    insertCouponSettingFixture(f)
}
