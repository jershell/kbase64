import com.github.jershell.kbase64.decodeBase64
import com.github.jershell.kbase64.encodeToBase64
import kotlin.test.Test
import kotlin.test.assertEquals


class ExtensionsTest {
    @Test
    fun decode() {
        assertEquals("", "".decodeBase64())
        assertEquals("1", "MQ==".decodeBase64())
        assertEquals("22", "MjI=".decodeBase64())
        assertEquals("333", "MzMz".decodeBase64())
        assertEquals("4444", "NDQ0NA==".decodeBase64())
    }

    @Test
    fun encode() {
        assertEquals("".encodeToBase64(), "")
        assertEquals("1".encodeToBase64(), "MQ==")
        assertEquals("22".encodeToBase64(), "MjI=")
        assertEquals("333".encodeToBase64(), "MzMz")
        assertEquals("4444".encodeToBase64(), "NDQ0NA==")
    }
}