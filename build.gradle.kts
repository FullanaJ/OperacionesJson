plugins {
    id("java")
    id("io.freefair.lombok") version "8.4"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.15.3")
}
buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("io.freefair.gradle:lombok-plugin:8.4")
    }
}

apply(plugin = "io.freefair.lombok")
tasks.test {
    useJUnitPlatform()
}