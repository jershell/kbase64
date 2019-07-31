import java.util.Date
import com.jfrog.bintray.gradle.tasks.entities.Artifact as BinTrayArtifact
apply(from = "groovy.gradle")

plugins {
    kotlin("multiplatform") version "1.3.41"
    id("maven-publish")
    id("com.jfrog.bintray") version "1.8.4"
}
val GROUP_ID = "com.github.jershell"
val ARTIFACT_ID = rootProject.name
val BINTRAY_REPOSITORY = "generic"
val BINTRAY_ORGINIZATION = "jershell"
val LIBRARY_VERSION_NAME = "0.0.1"

group = GROUP_ID
version = LIBRARY_VERSION_NAME

val groovyBintrayUpload: groovy.lang.Closure<Any?> by extra

tasks.bintrayUpload {
    doFirst {
        groovyBintrayUpload(this, publishing)
    }
}

bintray {
    user = project.property("user_name").toString()
    key = project.property("apikey").toString()
    publish = true
    override = false

    pkg.apply {
        repo = BINTRAY_REPOSITORY
        name = ARTIFACT_ID
        userOrg = BINTRAY_ORGINIZATION
        desc = "kotlin multiplatform base64 implementation"
        setLicenses("MIT")
        version.apply {
            name = LIBRARY_VERSION_NAME
            vcsTag = LIBRARY_VERSION_NAME
            released = Date().toString()
        }

        vcsUrl = "https://github.com/jershell/kbase64.git"
        websiteUrl = "https://github.com/jershell/kbase64"
        issueTrackerUrl = "https://github.com/jershell/kbase64/issues"

        setLabels("kotlin", "Base64", "multiplatform")
    }
}

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
    // For ARM, should be changed to iosArm32 or iosArm64
    // For Linux, should be changed to e.g. linuxX64
    // For MacOS, should be changed to e.g. macosX64
    // For Windows, should be changed to e.g. mingwX64
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

afterEvaluate {
    project.publishing.publications.all {
        this as MavenPublication
        //  rename artifacts
        this.groupId = GROUP_ID
        if (this.name.contains("metadata")) {
            this.artifactId = ARTIFACT_ID
        } else {
            this.artifactId = "$ARTIFACT_ID-${this.name}"
        }
        this as Publication
    }
}