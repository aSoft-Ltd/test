package tz.co.asoft

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

actual fun asyncTest(block: suspend CoroutineScope.() -> Unit) = GlobalScope.promise(block = block).unsafeCast<dynamic>()