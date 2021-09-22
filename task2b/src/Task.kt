package com.h0tk3y.spbsu.kotlin.course.lesson1

/*
 * Реализуйте функцию fibonacci, вычисляющую элемент последовательности Фибоначчи по номеру.
 * Нумерация элементов с единицы.
 * Функция должна иметь три целочисленных параметра:
 * 1. n – номер требуемого элемента последовательности. Для номеров, меньших единицы, возвращайте -1;
 * 2. first – значение первого элемента последовательности, имеет значение по умолчанию 1;
 * 3. second – значение второго элемента последовательности, использует first как значение по умолчанию
 * Целочисленное переполнение игнорируйте.
 */
fun fibonacci(n: Int, first: Int = 1, second: Int = first): Int {
    var pred = first
    var cur = second
    if (n < 1)
        return -1
    return when (n) {
        1 -> first
        2 -> second
        else -> {
            repeat(n - 1) {
                val tmp = pred
                pred = cur
                cur += tmp
            }
            pred
        }
    }
}

/*
 * Функцию должно быть можно вызывать следующими способами:
 * `fibonacci(42)`
 * `fibonacci(7, 1)`
 * `fibonacci(11, 0, 1)`
 * `fibonacci(7, first = 5)`
 * `fibonacci(42, first = 1, second = 1)`
 */