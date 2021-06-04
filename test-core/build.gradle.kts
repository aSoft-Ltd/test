plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

android {
    configureAndroid("src/androidMain")
}

kotlin {
    android { library() }
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
        val commonMain by getting {
            dependencies {
                api(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                api(kotlin("test-junit5"))
                api("androidx.test.espresso:espresso-core:${vers.androidx.espresso}")
                api("androidx.test:runner:${vers.androidx.test_runner}")
                api("androidx.test:rules:${vers.androidx.test_rules}")
            }
        }

        val jvmMain by getting {
            dependencies {
                api(kotlin("test-junit5"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "A Multiplatform testing library"
)