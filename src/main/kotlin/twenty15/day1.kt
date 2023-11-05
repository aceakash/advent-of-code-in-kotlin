package twenty15

fun partOne(input: String): Int {
    return input.fold(0) { next, acc -> next + if (acc == '(') 1 else -1 }
}

fun partTwo(input: String): Int {
    var floor = 0
    for (i in input.indices) {
        when (input[i]) {
            '(' -> floor++
            ')' -> floor--
        }
        if (floor == -1) {
            return i+1
        }
    }
    return 0
}
