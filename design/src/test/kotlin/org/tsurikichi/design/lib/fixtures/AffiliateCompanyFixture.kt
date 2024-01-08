package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDate

data class AffiliateCompanyFixture(
    val affiliate_company_code: Int = 0,
    val affiliate_company_name: String = "",
    val contract_start_date: LocalDate? = null,
    val contract_end_date: LocalDate? = null
)

fun DbSetupBuilder.insertAffiliateCompanyFixture(f: AffiliateCompanyFixture) {
    insertInto("affiliate_company") {
        mappedValues(
            "affiliate_company_code" to f.affiliate_company_code,
            "affiliate_company_name" to f.affiliate_company_name,
            "contract_start_date" to f.contract_start_date,
            "contract_end_date" to f.contract_end_date
        )
    }
}

fun DbSetupBuilder.insert(f: AffiliateCompanyFixture) {
    insertAffiliateCompanyFixture(f)
}
