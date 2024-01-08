import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.tooling.core.withClosure

plugins {
    java
    kotlin("jvm") version "1.9.22"
    `maven-publish`
    application
}


group = "com.github.LukynkaCZE"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

application {
    mainClass.set("MainKt")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}