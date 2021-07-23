import kotlinx.coroutines.*
import test.asyncTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ConcurrentModificationTest {
    class Tick(var count: Int)

    @Test
    fun should_count_inside_a_coroutine() = asyncTest {
        val tick = Tick(0)
        withContext(Dispatchers.Unconfined + Job()) {
            tick.count++
        }
        assertEquals(tick.count, 1)
    }
}