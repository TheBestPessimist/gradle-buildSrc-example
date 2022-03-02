plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

gradlePlugin {
    plugins {
        register("myversions-plugin") {
            id = "myversions"
            implementationClass = "land.tbp.wwsc.MyVersionsPlugin"
        }
    }
}

