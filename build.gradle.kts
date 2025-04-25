@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    `maven-publish`
    kotlin("multiplatform") version "2.1.20"
}

group = "cz.lukynka"
version = "1.5" // bumped vers just in case since there are major internal changes.

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

kotlin {
    // note: there doesnt seem to be an easy way to declare a main class/main entrypoint for natives other than jvm, so that might be an issue...
    mingwX64()
    macosX64()
    macosArm64()
    linuxX64()
    linuxArm64()
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.2")
            implementation("com.squareup.okio:okio:3.10.2")
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(kotlin("test-common"))
        }
    }

    jvmToolchain(17)
}

publishing {
    repositories {
        maven {
            url = uri("https://mvn.devos.one/releases")
            credentials {
                username = System.getenv()["MAVEN_USER"]
                password = System.getenv()["MAVEN_PASS"]
            }
        }
    }

    publications {
        register<MavenPublication>("maven") {
            groupId = "cz.lukynka"
            artifactId = "pretty-log"
            version = version
        }
    }
}