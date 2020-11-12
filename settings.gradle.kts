pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}
rootProject.name = "test"
listOf("../../build-src/code").mapNotNull {
    file(it).takeIf { file -> file.exists() }
}.forEach {
    includeBuild(it.relativeTo(file(".")))
}
