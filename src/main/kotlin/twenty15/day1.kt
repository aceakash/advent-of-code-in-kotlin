package twenty15

fun partOne(input: String): Int {
    var floor = 0

    for (c in input) {
        when (c) {
            '(' -> floor++
            ')' -> floor--
        }
    }

    return floor
}