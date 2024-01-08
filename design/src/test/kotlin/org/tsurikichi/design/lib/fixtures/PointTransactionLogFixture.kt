package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues

data class PointTransactionLogFixture(
    val receipt_number: Int? = null,
    val point_log_type: String? = null,
    val transaction_points: Int? = null
)

fun DbSetupBuilder.insertPointTransactionLogFixture(f: PointTransactionLogFixture) {
    insertInto("point_transaction_log") {
        mappedValues(
            "receipt_number" to f.receipt_number,
            "point_log_type" to f.point_log_type,
            "transaction_points" to f.transaction_points
        )
    }
}

fun DbSetupBuilder.insert(f: PointTransactionLogFixture) {
    insertPointTransactionLogFixture(f)
}
