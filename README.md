# kbase64
kotlin multiplatform base64 implementation


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