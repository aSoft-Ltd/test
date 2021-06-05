# Test

![badge][badge-maven] ![badge][badge-mpp] ![badge][badge-android] ![badge][badge-js] ![badge][badge-jvm]

An Opinionated testing library for kotlin multiplatform

## Introduction

Ever wanted to test suspending functions from common code without hack's? This is your spot

## Samples

In your testing code, you can do the following

```kotlin
    @Test
fun `should_test_a_suspend_function_with_no_problem`() = asyncTest {
        delayForFun()
        // do suspending tasks here and perform assertions on the results
    }
```

## Setup:Gradle

Adding test as a dependency becomes as easy as just

### Kotlin Multiplatform

```kotlin
kotlin {
    // . . .
    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation("tz.co.asoft:test-coroutines:1.1.32") // please use the latest version possible
            }
        }
    }
}
```

### Kotlin [android|jvm|js]

```kotlin
kotlin {
    // . . .
    dependencies {
        implementationTest("tz.co.asoft:test-coroutines:1.1.32") // please use the latest version possible
        /* Or
         * You can be as specific as
         * tz.co.asoft:test-js:+
         * tz.co.asoft:test-jvm:+
        */
    }
}
```

[badge-maven]: https://img.shields.io/maven-central/v/tz.co.asoft/test-core/1.1.32?style=flat

[badge-mpp]: https://img.shields.io/badge/kotlin-multiplatform-blue?style=flat

[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat

[badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat

[badge-jvm]: http://img.shields.io/badge/platform-jvm-orange.svg?style=flat
