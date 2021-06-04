plugins {
    kotlin("jvm")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    target {
        library()
        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":test-core"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "A set of helper functions to ease testing with selenium"
)