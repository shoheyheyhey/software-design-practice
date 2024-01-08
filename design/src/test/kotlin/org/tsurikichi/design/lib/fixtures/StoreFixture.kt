package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class StoreFixture(
    val affiliate_company_code: Int? = null,
    val store_code: Int = 0,
    val store_name: String = "",
    val location: String? = null
)

fun DbSetupBuilder.insertStoreFixture(f: StoreFixture) {
    insertInto("store") {
        mappedValues(
            "affiliate_company_code" to f.affiliate_company_code,
            "store_code" to f.store_code,
            "store_name" to f.store_name,
            "location" to f.location
        )
    }
}

fun DbSetupBuilder.insert(f: StoreFixture) {
    insertStoreFixture(f)
}
