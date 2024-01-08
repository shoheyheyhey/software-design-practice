package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDateTime

data class FlywaySchemaHistoryFixture(
    val installed_rank: Int = 0,
    val version: String? = null,
    val description: String = "",
    val type: String = "",
    val script: String = "",
    val checksum: Int? = null,
    val installed_by: String = "",
    val installed_on: LocalDateTime = LocalDateTime.now(),
    val execution_time: Int = 0,
    val success: Boolean = false
)

fun DbSetupBuilder.insertFlywaySchemaHistoryFixture(f: FlywaySchemaHistoryFixture) {
    insertInto("flyway_schema_history") {
        mappedValues(
            "installed_rank" to f.installed_rank,
            "version" to f.version,
            "description" to f.description,
            "type" to f.type,
            "script" to f.script,
            "checksum" to f.checksum,
            "installed_by" to f.installed_by,
            "installed_on" to f.installed_on,
            "execution_time" to f.execution_time,
            "success" to f.success
        )
    }
}

fun DbSetupBuilder.insert(f: FlywaySchemaHistoryFixture) {
    insertFlywaySchemaHistoryFixture(f)
}
