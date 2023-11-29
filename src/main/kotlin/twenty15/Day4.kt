package twenty15

import java.security.MessageDigest
import kotlin.text.Charsets.UTF_8



class Day4 {
    private fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
    private fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }


    fun partOne(input: String): Int {
        return findMD5WithPrefix(input, "00000")
    }

    fun partTwo(input: String): Int {
        return findMD5WithPrefix(input, "000000")
    }

    fun partThree(input: String): Int {
        return findMD5WithPrefix(input, "0")
    }

    private fun findMD5WithPrefix(secret: String, prefixToLookFor: String): Int {
        return (1..Int.MAX_VALUE)
            .find { md5("$secret$it").toHex().startsWith(prefixToLookFor) }
            ?: -1
    }
}
