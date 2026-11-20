plugins {
    kotlin("jvm") version "1.9.24"
    id("app.morphe.patches") version "2.1.1"
}

group = "app.opatches"
version = "1.0.0"

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(libs.kotlin.stdlib)
    compileOnly(libs.gson)
}
