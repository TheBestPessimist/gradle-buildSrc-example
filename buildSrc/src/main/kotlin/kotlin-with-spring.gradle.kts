// TODO: how can i not duplicate V?
object V {
    const val springBootVersion = "2.5.3"
    const val kotlinVersion = "1.5.10"
}

plugins {
    kotlin("jvm")
    id("org.springframework.boot")
//    TODO: what is the name of this plugin? how to import it? see the question inside the dependencies
//    kotlin("plugin.spring")

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


}


repositories {
    mavenCentral()

}
