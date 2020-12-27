package tz.co.asoft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun asyncTest(block: suspend CoroutineScope.() -> Unit) = runBlocking(block = block)