import land.tbp.wwsc.Versions.jacksonVersion
import land.tbp.wwsc.Versions.keycloakVersion
import land.tbp.wwsc.Versions.kittinunfResultVersion
import land.tbp.wwsc.Versions.logstashLogbackEncoderVersion
import land.tbp.wwsc.Versions.mockKVersion
import land.tbp.wwsc.Versions.prometheusVersion
import land.tbp.wwsc.Versions.springBootVersion
import land.tbp.wwsc.Versions.springCloudGcpPubsubVersion
import land.tbp.wwsc.Versions.springCloudVersion

plugins {
    id("land.tbp.wwsc.tralala")
}

group = "a"
version = "0.0.3"
description = "a"

dependencies {

    developmentOnly("org.springframework.boot:spring-boot-devtools:$springBootVersion")
    implementation("org.springframework.integration:spring-integration-core")

    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")

    implementation(platform("org.keycloak.bom:keycloak-adapter-bom:$keycloakVersion"))
    implementation("org.keycloak:keycloak-spring-boot-starter")

    implementation("com.google.cloud:spring-cloud-gcp-starter-pubsub:$springCloudGcpPubsubVersion")
    implementation("com.google.cloud:spring-cloud-gcp-starter-storage:$springCloudGcpPubsubVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")

    implementation("com.github.kittinunf.result:result:$kittinunfResultVersion")

    implementation("io.micrometer:micrometer-registry-prometheus:$prometheusVersion")
    implementation("net.logstash.logback:logstash-logback-encoder:$logstashLogbackEncoderVersion")

    testImplementation("io.mockk:mockk:$mockKVersion")
}
