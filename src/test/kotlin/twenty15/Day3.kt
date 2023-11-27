package twenty15


class Day3 {

    enum class Direction {
        N, S, E, W, UNKNOWN
    }

    fun partOne(rawInput: String): Int {
        val parsed = parseInput(rawInput)

        var curr = Pair(0, 0)
        val visited = mutableSetOf(curr) // starting location
        parsed.forEach { direction ->
            val newLocation = when(direction) {
                Direction.N -> Pair(curr.first, curr.second + 1)
                Direction.S -> Pair(curr.first, curr.second - 1)
                Direction.E -> Pair(curr.first + 1, curr.second)
                Direction.W -> Pair(curr.first - 1, curr.second)
                Direction.UNKNOWN -> curr
            }
            visited += newLocation
            curr = newLocation
        }

        return visited.size
    }

    fun partTwo(rawInput: String): Int {
        return 42
    }


    private fun parseInput(rawInput: String): List<Direction> {
        return rawInput.map {
            when (it) {
                '^' -> Direction.N
                '>' -> Direction.E
                '<' -> Direction.W
                'v' -> Direction.S
                else -> Direction.UNKNOWN
            }
        }
    }
}
