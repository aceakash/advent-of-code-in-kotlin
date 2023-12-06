package twenty23

class Day6 {
    fun part1(input: List<Pair<Long, Long>>): Long {
        return input.map { numberOfWaysToWin(it) }
            .fold(1) { acc, count ->
                acc * count
            }
    }

    private fun numberOfWaysToWin(timeAndDistance: Pair<Long, Long>): Int {
        val (time, distance) = timeAndDistance
        return (1 until time).count { hold ->
            hold * (time - hold) > distance
        }
    }

    fun part2(input: List<Pair<Long, Long>>): Long {
        return part1(input)
    }
}