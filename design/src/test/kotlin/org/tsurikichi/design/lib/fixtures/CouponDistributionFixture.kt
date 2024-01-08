package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDateTime

data class CouponDistributionFixture(
    val coupon_code: Int? = null,
    val member_code: Int? = null,
    val distributed_flag: Boolean? = null,
    val distribution_date_time: LocalDateTime? = null
)

fun DbSetupBuilder.insertCouponDistributionFixture(f: CouponDistributionFixture) {
    insertInto("coupon_distribution") {
        mappedValues(
            "coupon_code" to f.coupon_code,
            "member_code" to f.member_code,
            "distributed_flag" to f.distributed_flag,
            "distribution_date_time" to f.distribution_date_time
        )
    }
}

fun DbSetupBuilder.insert(f: CouponDistributionFixture) {
    insertCouponDistributionFixture(f)
}
