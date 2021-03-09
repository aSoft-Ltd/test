package test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

actual fun asyncTest(block: suspend CoroutineScope.() -> Any?): Unit = runBlocking { block() }