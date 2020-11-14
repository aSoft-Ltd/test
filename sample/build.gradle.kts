plugins {
    kotlin("multiplatform") version "1.4.10"
}

repositories {
    mavenCentral()
    jcenter()
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
                implementation("tz.co.asoft:test:+")
            }
        }
    }
}