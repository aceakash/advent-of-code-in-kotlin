package twenty15

fun partOne(input: String): Int {
    return input.fold(0) { next, acc -> next + if (acc == '(') 1 else -1 }
}