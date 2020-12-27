plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

group = "tz.co.asoft.tests"
version = "0.0.0"

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.useIR = true
        }
    }

    js(IR) {
        browser()
    }

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(project(":test-coroutines"))
            }
        }
    }
}