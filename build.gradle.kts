plugins {
    kotlin("multiplatform") version "1.3.41"
    id("maven-publish")
}

group = "com.github.jershell"
version = "0.0.1-SNAPSHOT"

repositories {
    jcenter()
}

kotlin {
    jvm().compilations["main"].defaultSourceSet {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        }
    }
    jvm().compilations["test"].defaultSourceSet {
        dependencies {
            implementation("org.jetbrains.kotlin:kotlin-test")
            implementation("org.jetbrains.kotlin:kotlin-test-junit")
        }
    }
    linuxX64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    println(targets.names)
}