# kbase64
[ ![Download](https://api.bintray.com/packages/jershell/generic/kbase64/images/download.svg) ](https://bintray.com/jershell/generic/kbase64/_latestVersion)

kotlin multiplatform base64 implementation

## Support platform

- jvm
- linuxX64

## Install

build.gradle.kts
```kotlin
repositories {
    maven { url = uri("https://dl.bintray.com/jershell/generic") }
}

dependencies {
    // FOR JVM
    implementation("com.github.jershell:kbase64-jvm:0.0.1")
}
```

build.gradle
```groovy
repositories {
    maven { 'https://dl.bintray.com/jershell/generic' }
}

dependencies {
    // FOR JVM
    implementation 'com.github.jershell:kbase64-jvm:0.0.1'
}
```
## API

```kotlin
// Base
ByteArray.decodeBase64()
ByteArray.encodeBase64()

// Extension function

// decode from String or ByteArray
String.decodeBase64()
String.decodeBase64ToByteArray() 
ByteArray.decodeBase64ToString()

// encode to String
String.encodeToBase64()
ByteArray.encodeToBase64()
```

## Usage

```kotlin

```