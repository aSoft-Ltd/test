package tz.co.asoft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

actual fun asyncTest(block: suspend () -> Unit) = runBlocking {
    block()
}

actual abstract class AsyncTest actual constructor() : CoroutineScope {
    actual override val coroutineContext: CoroutineContext = SupervisorJob()
    actual fun asyncTest(block: suspend () -> Unit) = runBlocking {
        block()
    }
}