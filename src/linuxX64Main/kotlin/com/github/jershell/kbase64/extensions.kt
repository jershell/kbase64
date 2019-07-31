package com.github.jershell.kbase64

actual fun String.decodeBase64(): String {
    return this.encodeToByteArray().decodeBase64().decodeToString()
}

actual fun String.decodeBase64ToByteArray(): ByteArray {
    return this.encodeToByteArray().decodeBase64()
}

actual fun ByteArray.decodeBase64ToString(): String {
    return this.decodeBase64().decodeToString()
}

actual fun String.encodeToBase64(): String {
    return this.encodeToByteArray().encodeBase64().decodeToString()
}

actual fun ByteArray.encodeToBase64(): String {
    return this.encodeBase64().decodeToString()
}