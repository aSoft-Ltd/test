import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.coroutines.promise
import test.asyncTest
import kotlin.js.Promise
import kotlin.test.Ignore
import kotlin.test.Test

class PromiseTestingTest {
    @Test
    fun should_wait_till_promise_resolves() = asyncTest {
        promise {
            delay(1000)
            console.log("I finished")
        }
    }

    private val promise = Promise<Int> { resolve, reject ->
        window.setTimeout({
            resolve(42)
        }, 1000)
    }

    @Test
    @Ignore
    fun should_wait_till_natural_promise_completes() = asyncTest {
        promise.then {
            console.log("got: $it")
            it + 1
        }
    }
}