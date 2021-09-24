package com.h0tk3y.spbsu.kotlin.course.lesson1

import kotlin.math.sign

/*
 * Реализуйте функцию factorial, вычисляющую значение факториала. Значение факториала нуля считайте едииницей.
 * Факториалом отрицательных чисел считайте -1. Целочисленное переполнение игнорируйте.
 */
fun factorial(n: Int): Int = when (n.sign) {
    -1 -> -1
    1 -> (1..n).reduce { acc, i -> i * acc }
    else -> 1
}