import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import tz.co.asoft.AsyncTest
import tz.co.asoft.delayForFun
import kotlin.coroutines.CoroutineContext
import kotlin.js.JsName
import kotlin.test.Test
import kotlin.test.assertEquals

class AsyncClassTest : AsyncTest() {
    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()

    @Test
    @JsName("Test0")
    fun `should test a suspend function with no problem`() = asyncTest {
        delayForFun()
        assertEquals(Unit, Unit)
    }
}