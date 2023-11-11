// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false

    // Add the dependency for the Google services Gradle plugin
    id("com.google.gms.google-services") version "4.4.0" apply false
}

buildscript {
    extra.apply {
        set("kotlin_version", "1.4.10")
        set("nav_version", "2.5.0")
    }
    repositories {
        google()
    }
    dependencies {
        val kotlinVersion = rootProject.extra.get("kotlin_version") as String
        val navVersion = rootProject.extra.get("nav_version") as String
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}