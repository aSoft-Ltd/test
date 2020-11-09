pluginManagement {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}
rootProject.name = "test"
listOf("../../build-src/code").mapNotNull {
    file(it).takeIf { file -> file.exists() }
}.forEach {
    includeBuild(it.relativeTo(file(".")))
}
