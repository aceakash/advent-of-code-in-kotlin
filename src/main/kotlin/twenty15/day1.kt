package twenty15

val move = { c: Char ->
    when (c) {
        '(' -> 1
        ')' -> -1
        else -> 0
    }
}

fun partOne(input: String): Int {
    return input.fold(0) { next, acc -> next + move(acc) }
}

fun partTwo(input: String): Int {
    var floor = 0
    for (i in input.indices) {
        floor += move(input[i])
        if (floor == -1) {
            return i + 1
        }
    }
    return 0
}
