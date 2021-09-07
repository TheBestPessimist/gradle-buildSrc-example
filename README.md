This is a simple project where I try to understand how to use gradle and `buildSrc` for dependency management. It is also used to ask the gradle folks for help.

All the "requests for help" in this project can be found by searching for "HELPME".

The initial project sources taken from gradle documentation itself: https://docs.gradle.org/current/samples/sample_convention_plugins.html. Press the "Kotlin DSL" button at the top.

Unfortunately those are rather lackluster as they don't help with setting up a proper application which uses multiple technologies. That's why I created this project which tries to set up a spring boot + kotlin project.


# Problems (HELPME)

This is a blocker for me right now, so it gets its own readme section.

## How can i find the name of a "plugin dependency"?

- `id("org.springframework.boot")` is found at https://plugins.gradle.org/plugin/org.springframework.boot and i assume the dependency is `implementation("org.springframework.boot:spring-boot-gradle-plugin:2.5.4")`
- `kotlin("jvm")` is found at https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm and i assume the dependency is `implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")`
- ❓ `kotlin("plugin.spring")` is found at https://plugins.gradle.org/plugin/org.jetbrains.kotlin.plugin.spring, however i have no idea what i should add as dependency.

The problem here (imo) is that the website https://plugins.gradle.org/ does not show the "plugin dependency name" itself.
It has 2 examples:

- `Using the plugins DSL`
- `Using legacy plugin application`

However, there is no `Using buildSrc plugin dependency`. Can that be added as well?



# How to run:

```
gradle clean check jacocoTestReport bootJar
```
