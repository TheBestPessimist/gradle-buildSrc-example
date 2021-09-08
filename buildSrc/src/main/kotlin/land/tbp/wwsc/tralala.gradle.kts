package land.tbp.wwsc
import land.tbp.wwsc.Versions.springBootVersion
import land.tbp.wwsc.Versions.h2Version
import land.tbp.wwsc.Versions.openApiVersion
import land.tbp.wwsc.Versions.springMockkVersion
import land.tbp.wwsc.Versions.assertJVersion
import land.tbp.wwsc.Versions.awaitilityVersion

plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    kotlin("plugin.spring")
    id("org.barfuin.gradle.taskinfo")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.sonarqube")
    jacoco
    application
}

repositories {
    mavenLocal()
    mavenCentral()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")


    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))

    implementation("com.h2database:h2:$h2Version")

    implementation("org.springdoc:springdoc-openapi-kotlin:$openApiVersion")
    implementation("org.springdoc:springdoc-openapi-ui:$openApiVersion")


    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("com.ninja-squad:springmockk:$springMockkVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")

    testImplementation("org.awaitility:awaitility-kotlin:$awaitilityVersion")


    configurations.all {
        exclude(group = "junit", module = "junit")
        exclude(module = "mockito-core")
        exclude(module = "mockito-all")
        exclude(module = "slf4j-log4j12")
        exclude(group = "org.liquibase")
    }
}

java.sourceCompatibility = Versions.javaVersion
java.targetCompatibility = Versions.javaVersion

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            @Suppress("SuspiciousCollectionReassignment")
            freeCompilerArgs += listOf("-Xjsr305=strict")
            jvmTarget = Versions.javaVersion.majorVersion
            languageVersion = Versions.kotlinLanguageApiVersion
            apiVersion = Versions.kotlinLanguageApiVersion
        }
    }
}

configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    verbose.set(true)
    disabledRules.set(setOf("no-wildcard-imports"))
}
