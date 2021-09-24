package com.h0tk3y.spbsu.kotlin.course.lesson1

/*
 * Реализуйте функцию intersectRanges, возвращающую диапазон, являющийся пересечением двух
 * данных целочисленных диапазонов. Если данные диапазоны не пересекаются, возвращайте null.
 *
 * Например, пересечением дипазонов `1..10` и `5..20` является `5..10`,
 * а диапазоны `0..0` и `1..1` не пересекаются.
 * 
 * Для получения границ диапазонов используйте свойства `first` и `last`.
 */
fun intersectRanges(rangeA: IntRange, rangeB: IntRange): IntRange? {
    if (rangeA.last < rangeB.first || rangeB.last < rangeA.first)
        return null
    return maxOf(rangeA.first, rangeB.first).rangeTo(minOf(rangeB.last, rangeA.last))
}

/*
 * Реализуйте функцию `cut`, которая возвращает список, содержащий от нуля до двух непрерывных
 * диапазонов, которые получаются из диапазона `outerRange`, если из него "вырезать" диапазон `cutout`.
 * (на самом деле, конечно же, "вырезать" из диапазона можно только его пересечение с другим диапазоном,
 *  а остальную часть другого диапазона следует отбросить)
 * 
 * Например, если из диапазона `0..10` вырезать `1..7`, получится два диапазона, `0..0` и `8..10`.
 * Если же из `0..10` вырезать `0..3`, то результатом будет только один диапазон `4..10`.
 */
fun cut(outerRange: IntRange, cutout: IntRange): List<IntRange> {
    val result = mutableListOf<IntRange>()
    val intersection : IntRange = intersectRanges(outerRange, cutout) ?: outerRange.first - 1 until outerRange.first;
    if (intersection.first == outerRange.first - 1) {
        result.add(outerRange)
        return result
    }
    val check1: Int = if (intersection.first == outerRange.first) {1} else {0}
    val check2: Int = if (intersection.last == outerRange.last) {10} else {100}
    when(check1 + check2) {
        101 -> {
            result.add(intersection.last + 1 .. outerRange.last)
        }
        10 -> {
            result.add(outerRange.first until intersection.first)
        }
        100 -> {
            result.add(outerRange.first .. intersection.first)
            result.add(intersection.last + 1 .. outerRange.last)
        }
    }
    return  result
}