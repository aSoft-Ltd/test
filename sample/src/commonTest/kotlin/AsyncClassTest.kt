import tz.co.asoft.asyncTest
import tz.co.asoft.delayForFun
import kotlin.test.Test
import kotlin.test.assertEquals

class AsyncClassTest {
    @Test
    fun should_test_a_suspend_function_with_no_problem() = asyncTest {
        delayForFun()
        assertEquals(Unit, Unit)
    }
}