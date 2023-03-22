package com.example.composeapp.carousel

object MathUtil{
    fun lerp(a: Float, b: Float, fraction: Float): Float {
        return a + fraction * (b - a)
    }
}
