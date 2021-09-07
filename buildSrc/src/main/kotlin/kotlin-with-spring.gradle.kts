// HELPME: how can i not duplicate V?
object V {
    const val springBootVersion = "2.5.3"
    const val kotlinVersion = "1.5.10"
    val javaVersion = JavaVersion.VERSION_11
}



plugins {
    kotlin("jvm")
    id("org.springframework.boot")
//    HELPME: what is the name of this plugin? how to import it? see the question inside the dependencies
//    kotlin("plugin.spring")


    id("org.barfuin.gradle.taskinfo")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.sonarqube")
    jacoco
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation(platform("org.springframework.boot:spring-boot-dependencies:${V.springBootVersion}"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.integration:spring-integration-core")
    developmentOnly("org.springframework.boot:spring-boot-devtools:${V.springBootVersion}")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")


    configurations.all {
        exclude(group = "junit", module = "junit")
        exclude(module = "mockito-core")
        exclude(module = "mockito-all")
        exclude(module = "slf4j-log4j12")
        exclude(group = "org.liquibase")
    }
}


repositories {
    mavenCentral()
}



tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += listOf("-Xjsr305=strict")
            jvmTarget = V.javaVersion.majorVersion
            languageVersion = "1.5"
            apiVersion = "1.5"
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }

    sonarqube {
        properties {
            property("sonar.projectName", "test")
            property("sonar.projectKey", "test")
            property("sonar.kotlin.coveragePlugin", "jacoco")
            property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/jacoco/test/jacocoTestReport.xml")
        }
    }

    test {
        finalizedBy(jacocoTestReport) // report is always generated after tests run
    }

    jacocoTestReport {
        dependsOn(test)

        reports {
            reports.html.required.set(true)
            reports.xml.required.set(true)
        }
    }
}


configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
    verbose.set(true)
    disabledRules.set(setOf("no-wildcard-imports"))
}
