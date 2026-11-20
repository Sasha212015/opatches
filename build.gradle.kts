plugins {
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
    compileOnly(libs.gson)
}