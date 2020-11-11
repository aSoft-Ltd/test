pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
}
rootProject.name = "test"
listOf("../../build-src/code").mapNotNull {
    file(it).takeIf { file -> file.exists() }
}.forEach {
    includeBuild(it.relativeTo(file(".")))
}
