package org.tsurikichi.design.lib.fixtures

// factlin generated file.

import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.mappedValues
import java.time.LocalDate

data class MemberFixture(
    val member_code: Int = 0,
    val member_name: String = "",
    val join_date: LocalDate? = null,
    val address: String? = null,
    val gender: String? = null,
    val date_of_birth: LocalDate? = null,
    val point_balance: Int? = null
)

fun DbSetupBuilder.insertMemberFixture(f: MemberFixture) {
    insertInto("member") {
        mappedValues(
            "member_code" to f.member_code,
            "member_name" to f.member_name,
            "join_date" to f.join_date,
            "address" to f.address,
            "gender" to f.gender,
            "date_of_birth" to f.date_of_birth,
            "point_balance" to f.point_balance
        )
    }
}

fun DbSetupBuilder.insert(f: MemberFixture) {
    insertMemberFixture(f)
}
