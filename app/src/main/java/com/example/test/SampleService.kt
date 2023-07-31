package com.example.test

import kotlinx.coroutines.delay

class SampleService constructor() {
    val list = listOf("a", "b", "c")
    var i = 0
    suspend fun getUserName(): String {
        // Simulate network call or database operation
        delay(1000)
        val str = list[i]
        i++
        if(i >= list.size) { i = 0 }
        return str
    }
}
