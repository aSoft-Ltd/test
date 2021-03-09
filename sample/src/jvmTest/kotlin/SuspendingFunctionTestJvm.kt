import kotlinx.coroutines.runBlocking
import test.delayForFun
import kotlin.test.Test
import kotlin.test.assertEquals

class SuspendingFunctionTestJvm {
    @Test
    fun `should test a suspend function with no problem`() = runBlocking {
        delayForFun()
        assertEquals(Unit, Unit)
    }
}