/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package kbase64

const val dictionaryOfBase64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"


fun ByteArray.encodeBase64(): ByteArray {
    val output = mutableListOf<Byte>()
    var padding = 0
    var position = 0
    while (position < this.size) {
        var b = this[position].toInt() and 0xFF shl 16 and 0xFFFFFF
        if (position + 1 < this.size) b = b or (this[position + 1].toInt() and 0xFF shl 8) else padding++
        if (position + 2 < this.size) b = b or (this[position + 2].toInt() and 0xFF) else padding++
        for (i in 0 until 4 - padding) {
            val c = b and 0xFC0000 shr 18
            output.add(dictionaryOfBase64[c].toByte())
            b = b shl 6
        }
        position += 3
    }
    for (i in 0 until padding) {
        output.add('='.toByte())
    }
    return output.toByteArray()
}