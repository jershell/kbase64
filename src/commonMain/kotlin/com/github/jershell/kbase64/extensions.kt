package com.github.jershell.kbase64

expect fun String.decodeBase64(): String
expect fun String.decodeBase64ToByteArray() : ByteArray
expect fun ByteArray.decodeBase64ToString() : String

expect fun String.encodeToBase64(): String
expect fun ByteArray.encodeToBase64(): String
