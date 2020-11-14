import tz.co.asoft.asyncTest
import tz.co.asoft.delayForFun
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals

class SuspendingFunctionTest {
    @Test
    @JsName("Test0")
    fun `should test a suspend function with no problem`() = asyncTest {
        delayForFun()
        assertEquals(Unit, Unit)
    }
}