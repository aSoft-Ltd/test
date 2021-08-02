plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

group = "tz.co.asoft.tests"
version = "0.0.0"

kotlin {
    jvm { library() }

    js(IR) { library() }

    nativeTargets(false)

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(project(":test-coroutines"))
            }
        }
    }
}