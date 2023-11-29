package twenty15

class Day1 {
    private val move = { c: Char ->
        when (c) {
            '(' -> 1
            ')' -> -1
            else -> 0
        }
    }

    fun partOne(input: String): Int {
        return input.map(move).sum()
    }

    fun partTwoFunctional(input: String): Int {
        return input.map(move).foldIndexed(0) { index, acc, floorMovement ->
            val hasReachedBasement = acc + floorMovement == -1
            if (hasReachedBasement) {
                return index + 1 // since users need 1-based index
            }
            acc + floorMovement
        }
    }

    fun partTwoSimple(input: String): Int {
        var floor = 0

        for (i in input.indices) {
            floor += move(input[i])
            if (floor == -1) {
                return i + 1
            }
        }
        return 0
    }


}
