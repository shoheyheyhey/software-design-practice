package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class CrossAnalysisProductFixture(
    val cross_analysis_product_code: Int = 0,
    val cross_analysis_product_name: String = ""
)

fun DbSetupBuilder.insertCrossAnalysisProductFixture(f: CrossAnalysisProductFixture) {
    insertInto("cross_analysis_product") {
        mappedValues(
            "cross_analysis_product_code" to f.cross_analysis_product_code,
            "cross_analysis_product_name" to f.cross_analysis_product_name
        )
    }
}

fun DbSetupBuilder.insert(f: CrossAnalysisProductFixture) {
    insertCrossAnalysisProductFixture(f)
}
