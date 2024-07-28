plugins {
    `maven-publish`
    kotlin("jvm") version "1.9.22"
    application
}

group = "cz.lukynka"
version = "1.4"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()

}

application {
    mainClass.set("MainKt")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
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
            from(components["java"])
        }
    }
}