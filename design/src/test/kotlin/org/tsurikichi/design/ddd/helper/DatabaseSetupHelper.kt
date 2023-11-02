package org.tsurikichi.design.ddd.helper

import nu.studer.sample.tables.Member
import nu.studer.sample.tables.Payment
import org.jooq.DSLContext
import org.springframework.stereotype.Service

@Service
class DatabaseSetupHelper(private val dslContext: DSLContext) {

    fun truncateAll() {
        val tables = listOf(Member.MEMBER, Payment.PAYMENT)

        for (table in tables) {
            dslContext.truncate(table).cascade().execute()
        }
    }
}
