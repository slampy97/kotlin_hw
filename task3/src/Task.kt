
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

    val fst = intersection.first == outerRange.first
    val snd = intersection.last == outerRange.last

    when {
        (fst && !snd) -> {
            result.add(intersection.last + 1 .. outerRange.last)
        }

        (!fst && snd) -> {
            result.add(outerRange.first until intersection.first)
        }

        (!fst && !snd) -> {
            result.add(outerRange.first .. intersection.first)
            result.add(intersection.last + 1 .. outerRange.last)
        }
    }

    return  result
}
