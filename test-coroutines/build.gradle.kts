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
                api(kotlinx("coroutines-core", vers.kotlinx.coroutines))
                api(project(":test-core"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.test,
    description = "An extension to the test-core artifact to help testing coroutines"
)