package com.iamer.movies

abstract class UnitTest {

    fun fail(message: String): Nothing = throw AssertionError(message)
}
