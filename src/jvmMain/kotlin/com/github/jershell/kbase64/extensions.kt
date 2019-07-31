package com.github.jershell.kbase64

actual fun String.decodeBase64(): String = String(this.toByteArray().decodeBase64())
actual fun String.decodeBase64ToByteArray(): ByteArray = this.toByteArray().decodeBase64()
actual fun ByteArray.decodeBase64ToString(): String = String(this.decodeBase64())
actual fun String.encodeToBase64(): String = String(this.toByteArray().encodeBase64())
actual fun ByteArray.encodeToBase64(): String = String(this.encodeBase64())