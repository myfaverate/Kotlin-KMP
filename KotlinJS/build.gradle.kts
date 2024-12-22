plugins {
    kotlin("multiplatform") version "2.1.0"
}

group = "edu.tyut"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}
kotlin {
    js {
        browser() // browser or nodejs
        // nodejs()
        binaries.executable()
    }
    jvmToolchain(21)
}