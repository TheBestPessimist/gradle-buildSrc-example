import land.tbp.wwsc.Versions

plugins {
    java
    myversions apply true
}

group = "a"
version = "0.0.3"
description = "a"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

val versions:Versions by project.extra

dependencies {
    implementation("org.springframework.boot:spring-boot-devtools:${versions.springBootVersion}")
}
