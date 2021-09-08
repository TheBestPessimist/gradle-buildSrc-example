// TODO: HELPME
// How to use the versions from the central location `land.tbp.wwsc.Versions`?
// Using the following imports does not work as the imports aren't found.
//import land.tbp.wwsc.Versions.gradleTaskinfoVersion
//import land.tbp.wwsc.Versions.kotlinLibraryVersion
//import land.tbp.wwsc.Versions.ktlintGradleVersion
//import land.tbp.wwsc.Versions.sonarqubeVersion
//import land.tbp.wwsc.Versions.springBootVersion
/////////////////

// So, I have to duplicate the imports code, which is bad.
val kotlinLibraryVersion = "1.5.10"
val springBootVersion = "2.5.3"
val ktlintGradleVersion = "10.1.0"
val sonarqubeVersion = "3.3"
val gradleTaskinfoVersion = "1.3.0"

/*
How to test?

Comment the val calls above and uncomment the imports. gradle will complain that it doesn't know what to import.
 */
plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinLibraryVersion")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")

    implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinLibraryVersion")
    implementation("org.jetbrains.kotlin:kotlin-noarg:$kotlinLibraryVersion")

    implementation("gradle.plugin.org.barfuin.gradle.taskinfo:gradle-taskinfo:$gradleTaskinfoVersion")
    implementation("org.jlleitschuh.gradle:ktlint-gradle:$ktlintGradleVersion")
    implementation("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:$sonarqubeVersion")
}
