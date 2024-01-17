plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:8.0.0")

    //This Line added to fix issue related to hilt
    implementation("com.squareup:javapoet:1.13.0")
}