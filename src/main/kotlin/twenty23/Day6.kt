package twenty23

class Day6 {
    fun part1(input: List<Pair<Int, Int>>): Int {
        return input.map { numberOfWaysToWin(it) }
            .fold(1) { acc, count ->
                acc * count
            }
    }

    private fun numberOfWaysToWin(timeAndDistance: Pair<Int, Int>): Int {
        val (time, distance) = timeAndDistance
        return (0..time).count { hold ->
            hold * (time - hold) > distance
        }
    }

    fun part2(input: String): Int {
        return 42
    }
}