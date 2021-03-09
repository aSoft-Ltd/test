package test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun asyncTest(block: suspend CoroutineScope.() -> Any?) = GlobalScope.promise(block = block).unsafeCast<dynamic>()