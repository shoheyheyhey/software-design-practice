package org.tsurikichi.design.lib.helper

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder

fun DbSetupBuilder.deleteAllTables() {
    deleteAllFrom(
        listOf(
            "point_transaction_log",
            "coupon_distribution",
            "coupon_usage",
            "purchase_product_detail",
            "payment_method_detail",
            "payment",
            "member"
        )
    )
}
