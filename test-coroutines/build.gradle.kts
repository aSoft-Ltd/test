plugins {
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    multiplatformLib()
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
        linuxX64()
    )
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx("coroutines-core", vers.kotlinx.coroutines))
                api(project(":test-core"))
            }
        }

        val commonTest by getting {}

        val jvmAndNativeMain by creating {
            dependsOn(commonMain)
        }

        val jvmAndNativeTest by creating {
            dependsOn(jvmAndNativeMain)
            dependsOn(commonTest)
        }

        val jvmMain by getting {
            dependsOn(jvmAndNativeMain)
        }

        val jvmTest by getting {
            dependsOn(jvmAndNativeTest)
        }

        for (target in linuxTargets + darwinTargets) {
            val main by target.compilations.getting {
                defaultSourceSet {
                    dependsOn(jvmAndNativeMain)
                }
            }

            val test by target.compilations.getting {
                defaultSourceSet {
                    dependsOn(commonTest)
                }
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "An extension to the test-core artifact to help testing coroutines"
)