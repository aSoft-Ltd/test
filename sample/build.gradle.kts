plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
}

group = "tz.co.asoft.tests"
version = "0.0.0"

kotlin {
    jvm { library() }

    js(IR) { library() }

    val darwinTargets = listOf(
        macosX64(),
        iosArm64(),
        iosArm32(),
        iosX64(),
        watchosArm32(),
        watchosArm64(),
        watchosX86(),
        tvosArm64(),
        tvosX64()
    )

    val linuxTargets = listOf(
        linuxArm64(),
        linuxArm32Hfp(),
        linuxX64()
    )

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(project(":test-coroutines"))
            }
        }
    }
}