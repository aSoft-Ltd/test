import kotlinx.coroutines.delay
import tz.co.asoft.asyncTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ApiTest {
    @Test
    fun should_not_affect_regular_testing() = asyncTest {
        delay(500)
        assertEquals(2, 1 + 1)
    }
}