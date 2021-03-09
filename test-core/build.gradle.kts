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
    multiplatformLib(forAndroid=true)
    val isMac = System.getenv("MACHINE") == "mac"
    val darwinTargets = if (isMac) listOf(
        macosX64(),
        iosArm64(),
        iosArm32(),
        iosX64(),
        watchosArm32(),
        watchosArm64(),
        watchosX86(),
        tvosArm64(),
        tvosX64()
    ) else emptyList()

    val linuxTargets = listOf(
        linuxArm64(),
        linuxArm32Hfp(),
        linuxX64()
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("test-common"))
                api(kotlin("test-annotations-common"))
            }
        }

        val androidMain by getting {
            dependencies {
                api(kotlin("test"))
                api(kotlin("test-junit"))
                api("androidx.test.espresso:espresso-core:${vers.androidx.espresso}")
                api("androidx.test:runner:${vers.androidx.test_runner}")
                api("androidx.test:rules:${vers.androidx.test_rules}")
            }
        }

        val jvmMain by getting {
            dependencies {
                api(kotlin("test"))
                api(kotlin("test-junit"))
            }
        }

        val jsMain by getting {
            dependencies {
                api(kotlin("test-js"))
            }
        }

        val nativeMain by creating {
            dependsOn(commonMain)
        }

        for (target in linuxTargets + darwinTargets) {
            val main by target.compilations.getting {
                defaultSourceSet {
                    dependsOn(nativeMain)
                }
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "A Multiplatform testing library"
)