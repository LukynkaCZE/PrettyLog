plugins {
    id("com.vanniktech.maven.publish") version "0.31.0"
    kotlin("multiplatform") version "2.1.20"
    id("com.android.library") version "8.9.2"
}

group = "cz.lukynka"
version = "1.8"

java.sourceCompatibility = JavaVersion.VERSION_17


android {
    compileSdk = 34
    namespace = "cz.lukynka.prettylog"

    defaultConfig {
        minSdk = 21
    }

    testOptions {
        targetSdk = 34
    }

    lint {
        targetSdk = 34
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
    }
    mingwX64()
    macosX64()
    macosArm64()
    linuxX64()
    linuxArm64()
    jvm()
    js {
        browser()
        nodejs()
    }
    wasmJs {
        browser()
        nodejs()
    }

    // Add compiler flag to suppress expect/actual classes Beta warning
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }

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
