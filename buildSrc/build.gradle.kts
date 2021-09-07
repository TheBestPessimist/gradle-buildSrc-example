// HELPME: how can i not duplicate V?
object V {
    const val springBootVersion = "2.5.3"
    const val kotlinVersion = "1.5.10"
}


plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal() // so that external plugins can be resolved in dependencies section
}

dependencies {
    implementation("gradle.plugin.com.github.spotbugs.snom:spotbugs-gradle-plugin:4.6.2")
    testImplementation("junit:junit:4.13")

    // used for kotlin with spring project
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${V.kotlinVersion}")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${V.springBootVersion}")

//    HELPME: what is the name of the plugin containing kotlin spring ( kotlin("plugin.spring") )?
//      From https://plugins.gradle.org/plugin/org.jetbrains.kotlin.plugin.spring, i expect it to be
//      implementation("org.jetbrains.kotlin:kotlin-allopen:1.5.10")
//      but that makes no sense.
//      @gradle documentation folks: Where can i find the name of the plugins??


    implementation("gradle.plugin.org.barfuin.gradle.taskinfo:gradle-taskinfo:1.3.0")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:10.1.0")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.3")


}
