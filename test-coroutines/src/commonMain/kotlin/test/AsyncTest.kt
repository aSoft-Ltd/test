package test

import kotlinx.coroutines.CoroutineScope

expect fun asyncTest(block: suspend CoroutineScope.() -> Any?)