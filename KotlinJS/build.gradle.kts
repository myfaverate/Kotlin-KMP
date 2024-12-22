plugins {
    kotlin("multiplatform") version "2.1.0"
}

group = "edu.tyut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    // 只能使用 npm 平台的库
    commonMainImplementation(npm("js-yaml", "4.1.0"))
    commonMainImplementation(npm("axios", "1.7.9"))
}
kotlin {
    js {
        browser() // browser or nodejs
        // nodejs()
        binaries.executable()
    }
    jvmToolchain(21)
}