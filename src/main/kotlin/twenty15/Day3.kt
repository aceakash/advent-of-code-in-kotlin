package twenty15


class Day3 {

    enum class Direction {
        N, S, E, W, UNKNOWN
    }

    fun partOne(rawInput: String): Int {
        val parsed = parseInput(rawInput)

        return visit(parsed).size
    }

    fun visit(directions: List<Direction>): Set<Pair<Int, Int>> {
        var curr = Pair(0, 0)
        val visited = mutableSetOf(curr) // starting location
        directions.forEach { direction ->
            val newLocation = when (direction) {
                Direction.N -> Pair(curr.first, curr.second + 1)
                Direction.S -> Pair(curr.first, curr.second - 1)
                Direction.E -> Pair(curr.first + 1, curr.second)
                Direction.W -> Pair(curr.first - 1, curr.second)
                Direction.UNKNOWN -> curr
            }
            visited += newLocation
            curr = newLocation
        }

        return visited
    }

    fun partTwo(rawInput: String): Int {
        val parsed = parseInput(rawInput)

        val evens = parsed.filterIndexed { index, _ -> index % 2 == 0 }
        val odds = parsed.filterIndexed { index, _ -> index % 2 == 1 }

        val set1 = setOf(Pair(0, 0))
        val set2 = visit(evens)
        val set3 = visit(odds)

        return (set1 union set2 union set3).size


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
