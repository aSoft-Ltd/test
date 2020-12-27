package tz.co.asoft

import kotlinx.coroutines.CoroutineScope

expect fun asyncTest(block: suspend CoroutineScope.() -> Unit)