plugins {
    id("tz.co.asoft.gradle-plugin.lib-multiplatform")
    id("tz.co.asoft.gradle-plugin.lib-android")
    id("io.codearte.nexus-staging") version ("0.22.0")
    signing
}

object vers {
    val selenium = "4.0.0-alpha-6"

    object androidx {
        val espresso = "3.1.0"
        val test_runner = "1.1.0"
        val test_rules = "1.1.0"
    }
}

group = "tz.co.asoft"
version = "1.0.1"
description = "A Multiplatform testing library"
url = "https://github.com/aSoft-Ltd/test"
scmConnection = "scm:git:git://github.com/aSoft-Ltd/test.git"
scmDeveloperConnection = "scm:git:https://github.com/aSoft-Ltd/test.git"
licenseName = "MIT License"
licenseUrl = "https://github.com/aSoft-Ltd/test/blob/master/LICENSE"
developerId = "andylamax"
developerName = "Anderson Lameck"

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

val nexusUsername = System.getenv("ASOFT_NEXUS_USERNAME") ?: "null" //"P0ZW8VYf"
val nexusPassword = System.getenv("ASOFT_NEXUS_PASSWORD") ?: "null" //"bhbdCSvPlI0Y9OidU8uLxx205/XWJTEMeCQhKE+T3I1B"
val pgpPrivateKey = System.getenv("ASOFT_MAVEN_PGP_PRIVATE_KEY") ?: ""
val pgpPassword = System.getenv("ASOFT_MAVEN_PGP_PASSWORD")

nexusStaging {
    username = nexusUsername
    password = nexusPassword
}

configureSigning(privateKey = pgpPrivateKey, password = pgpPassword)

configurePublishing {
    repositories {
        configureMavenCentralRepos(username = nexusUsername, password = nexusPassword)
    }
}