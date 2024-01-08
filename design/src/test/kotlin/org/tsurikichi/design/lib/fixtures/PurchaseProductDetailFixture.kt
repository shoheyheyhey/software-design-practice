package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class PurchaseProductDetailFixture(
    val receipt_number: Int? = null,
    val affiliate_company_code: Int? = null,
    val affiliate_product_code: Int? = null,
    val purchase_count: Int? = null,
    val product_unit_price: Int? = null,
    val given_point: Int? = null
)

fun DbSetupBuilder.insertPurchaseProductDetailFixture(f: PurchaseProductDetailFixture) {
    insertInto("purchase_product_detail") {
        mappedValues(
            "receipt_number" to f.receipt_number,
            "affiliate_company_code" to f.affiliate_company_code,
            "affiliate_product_code" to f.affiliate_product_code,
            "purchase_count" to f.purchase_count,
            "product_unit_price" to f.product_unit_price,
            "given_point" to f.given_point
        )
    }
}

fun DbSetupBuilder.insert(f: PurchaseProductDetailFixture) {
    insertPurchaseProductDetailFixture(f)
}
