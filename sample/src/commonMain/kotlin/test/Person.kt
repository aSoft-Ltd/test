package test

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.random.Random

data class Person(val name: String)

suspend fun delayForFun(): Boolean = suspendCoroutine {
    it.resume(Random.nextInt() > Random.nextInt())
}