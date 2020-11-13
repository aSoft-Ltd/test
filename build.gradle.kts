plugins {
    id("com.android.library") version "4.1.0"
    kotlin("multiplatform") version "1.4.10"
    id("tz.co.asoft.library") version "0.0.7"
    id("io.codearte.nexus-staging") version "0.22.0"
    signing
}

object vers {
    val selenium = "4.0.0-alpha-6"
    val asoft_test = "1.0.1"

    object androidx {
        val espresso = "3.1.0"
        val test_runner = "1.1.0"
        val test_rules = "1.1.0"
    }
}

kotlin {
    universalLib()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${versions.kotlinx.coroutines}")
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
                api("org.seleniumhq.selenium:selenium-java:${vers.selenium}")
            }
        }

        val jsMain by getting {
            dependencies {
                api(kotlin("test-js"))
            }
        }
    }
}

aSoftLibrary(
    version = vers.asoft_test,
    description = "A Multiplatform testing library"
)