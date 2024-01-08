package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDate

data class PointSettingFixture(
    val point_setting_code: Int = 0,
    val applicable_start_date: LocalDate? = null,
    val applicable_end_date: LocalDate? = null,
    val point_rate: Double? = null
)

fun DbSetupBuilder.insertPointSettingFixture(f: PointSettingFixture) {
    insertInto("point_setting") {
        mappedValues(
            "point_setting_code" to f.point_setting_code,
            "applicable_start_date" to f.applicable_start_date,
            "applicable_end_date" to f.applicable_end_date,
            "point_rate" to f.point_rate
        )
    }
}

fun DbSetupBuilder.insert(f: PointSettingFixture) {
    insertPointSettingFixture(f)
}
