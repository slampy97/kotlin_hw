package com.h0tk3y.spbsu.kotlin.course.lesson1

import kotlin.math.max
import kotlin.math.min

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
    return max(rangeA.first, rangeB.first).rangeTo(min(rangeB.last, rangeA.last))
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
    val intersection = intersectRanges(outerRange, cutout)
    if (intersection != null) {
        if ((intersection.first == outerRange.first) && (intersection.last == outerRange.last))
            return result
        if (intersection.first == outerRange.first) {
            result.add((intersection.last + 1).rangeTo(outerRange.last))
            return result
        }
        if (intersection.last == outerRange.last) {
            result.add(outerRange.first until intersection.first)
            return result
        }
        result.add(outerRange.first.rangeTo(intersection.first))
        result.add((intersection.last + 1).rangeTo(outerRange.last))
        return result
    }
    result.add(outerRange)
    return result
}