package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class AffiliateProductFixture(
    val affiliate_company_code: Int? = null,
    val affiliate_product_code: Int = 0,
    val cross_analysis_product_code: Int? = null,
    val affiliate_product_name: String = "",
    val jan_code: String? = null
)

fun DbSetupBuilder.insertAffiliateProductFixture(f: AffiliateProductFixture) {
    insertInto("affiliate_product") {
        mappedValues(
            "affiliate_company_code" to f.affiliate_company_code,
            "affiliate_product_code" to f.affiliate_product_code,
            "cross_analysis_product_code" to f.cross_analysis_product_code,
            "affiliate_product_name" to f.affiliate_product_name,
            "jan_code" to f.jan_code
        )
    }
}

fun DbSetupBuilder.insert(f: AffiliateProductFixture) {
    insertAffiliateProductFixture(f)
}
