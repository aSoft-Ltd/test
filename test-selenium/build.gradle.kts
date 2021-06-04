plugins {
    kotlin("jvm")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    target { library() }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":test-coroutines"))
                api("org.seleniumhq.selenium:selenium-java:${vers.selenium}")
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "A set of helper functions to ease testing with selenium"
)