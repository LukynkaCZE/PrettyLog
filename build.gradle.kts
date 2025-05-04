plugins {
    id("com.vanniktech.maven.publish") version "0.31.0"
    kotlin("multiplatform") version "2.1.20"
}

group = "cz.lukynka"
version = "1.9"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

kotlin {
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

        jvmMain.dependencies {
            api("org.slf4j:slf4j-api:2.0.17")
        }

        jvmTest.dependencies {
            implementation(kotlin("test"))
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