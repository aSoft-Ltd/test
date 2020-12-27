plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    universalLib()
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
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "A Multiplatform testing library"
)