import nu.studer.gradle.jooq.JooqEdition
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jooq.meta.jaxb.Logging
import org.jooq.meta.jaxb.Property

buildscript {
    repositories {
        mavenCentral() // factlin is published at jcenter
    }
    dependencies {
        classpath("com.maeharin:factlin:0.3.0")
        classpath("org.postgresql:postgresql:42.5.1")
    }
}

plugins {
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"
    id("org.flywaydb.flyway") version "7.15.0"
    id("nu.studer.jooq") version "8.2.1"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
}

group = "org.tsurikichi"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
    mavenCentral()
}

apply(plugin = "factlin")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jooq:jooq:3.18.7")
    implementation("com.ninja-squad:DbSetup-kotlin:2.1.0")
    jooqGenerator("org.postgresql:postgresql:42.5.1")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.mockk:mockk:1.13.8")

    runtimeOnly("org.postgresql:postgresql:42.6.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "19"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

flyway {
    url = "jdbc:postgresql://localhost:5432/sampledb"
    user = "root"
    password = "root"
    locations = arrayOf("filesystem:../database/src/migration", "filesystem:../database/src/seed")
}

jooq {
    version.set("3.18.4")
    edition.set(JooqEdition.OSS)

    configurations {
        create("main") {
            jooqConfiguration.apply {
                logging = Logging.WARN
                jdbc.apply {
                    driver = "org.postgresql.Driver"
                    url = "jdbc:postgresql://localhost:5432/sampledb"
                    user = "root"
                    password = "root"
                    properties = listOf(
                        Property().apply {
                            key = "PAGE_SIZE"
                            value = "2048"
                        }
                    )
                }
                generator.apply {
                    name = "org.jooq.codegen.DefaultGenerator"
                    database.apply {
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        inputSchema = "public"
                    }
                    generate.apply {
                        isDeprecated = false
                        isRecords = false
                        isImmutablePojos = false
                        isFluentSetters = false
                    }
                    target.apply {
                        packageName = "nu.studer.sample"
                        directory = "src/generated/jooq"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

configure<com.maeharin.factlin.gradle.FactlinExtension> {
    dbUrl = "jdbc:postgresql://localhost:5432/sampledb"
    dbUser = "root"
    dbPassword = "root"
    dbDialect = "postgres"
    fixtureOutputDir = "src/test/kotlin/org/tsurikichi/design/lib/fixtures"
    fixturePackageName = "org.tsurikichi.design.lib.fixtures"
    fixtureTemplatePath = "src/test/resources/factlin/class_template.ftl"
    schema = "public"
}
