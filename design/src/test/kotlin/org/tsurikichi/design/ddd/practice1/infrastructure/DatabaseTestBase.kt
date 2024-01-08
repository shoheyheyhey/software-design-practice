package org.tsurikichi.design.ddd.practice1.infrastructure

import com.ninja_squad.dbsetup.bind.DefaultBinderConfiguration
import com.ninja_squad.dbsetup.destination.DriverManagerDestination
import com.ninja_squad.dbsetup_kotlin.DbSetupBuilder
import com.ninja_squad.dbsetup_kotlin.dbSetup

abstract class DatabaseTestBase {

    fun db(configure: DbSetupBuilder.() -> Unit) {
        dbSetup(DriverManagerDestination("jdbc:postgresql://localhost:5432/sampledb", "root", "root"), DefaultBinderConfiguration.INSTANCE, configure).launch()
    }
}
