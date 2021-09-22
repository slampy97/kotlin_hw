package com.h0tk3y.spbsu.kotlin.course.lesson1

import java.lang.RuntimeException
import kotlin.math.sign

/*
 * Реализуйте функцию factorial, вычисляющую значение факториала. Значение факториала нуля считайте едииницей.
 * Факториалом отрицательных чисел считайте -1. Целочисленное переполнение игнорируйте.
 */
fun factorial(n: Int): Int = when (n.sign) {
    -1 -> -1
    1 -> (1..n).reduce { acc, i -> i * acc }
    0 -> 1
    else -> throw RuntimeException("It is impossible!")
}
