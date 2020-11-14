package tz.co.asoft

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

actual fun asyncTest(block: suspend () -> Unit) = GlobalScope.promise {
    block()
}.unsafeCast<dynamic>()

actual abstract class AsyncTest actual constructor() : CoroutineScope {
    actual override val coroutineContext: CoroutineContext = SupervisorJob()
    actual fun asyncTest(block: suspend () -> Unit) = promise {
        block()
    }.unsafeCast<Unit>()
}