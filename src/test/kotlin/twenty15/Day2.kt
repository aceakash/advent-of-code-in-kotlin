package twenty15


class Day2 {

    fun partOne(rawInput: String): Int {
        return parseInput(rawInput).sumOf { present ->
            val dims = present.sorted()
            val slack = dims[0] * dims[1]
            (2 * dims[0] * dims[1]) + (2 * dims[0] * dims[2]) + (2 * dims[2] * dims[1]) + slack
        }
    }

    fun partTwo(rawInput: String): Int {
        return parseInput(rawInput).sumOf { present ->
            val dims = present.sorted()
            val bow = dims[0] * dims[1] * dims[2]
            2 * (dims[0] + dims[1]) + bow
        }
    }


    private fun parseInput(rawInput: String): List<List<Int>> {
        return rawInput.split('\n')
            .map { line: String ->
                line.split('x').map { it.toInt() }
            }
    }
}
