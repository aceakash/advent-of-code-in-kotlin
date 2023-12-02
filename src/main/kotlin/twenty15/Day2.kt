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


    fun partOneSeq(rawInput: String): Int {
        val ans = rawInput.split("\n")
            .map { line ->
                val lineNumberList: List<Int> = parseLine(line)
                lineNumberList
                // "4x5x6" --> 4,5,6
            }
            .map { numList ->
                val smallestSideArea = numList.sorted()[0] * numList.sorted()[1]
                2*numList[0]*numList[1] + 2*numList[1]*numList[2] +2*numList[0]*numList[2] + smallestSideArea
             }
            .sum()
        return 0
    }

    private fun parseLine(line: String): List<Int> {
        return listOf(1, 2, 3)
    }


    fun wrappingPaperCalc(str: String): Map<String, Int> {


        var sum: Int = 0
        var ribbon: Int = 0
        val splitBoxes: List<String> = str.split("\n")
        splitBoxes.forEach {
            val measurement: List<String> = it.split("x")
            val intList: List<Int> = measurement.map {
                it.toInt()
            }
            val length: Int = intList[0]
            val width: Int = intList[1]
            val height: Int = intList[2]
            val ordered: List<Int> = intList.sorted()
            val smallest: Int = ordered[0] * ordered[1]
            ribbon += (ordered[0] * 2 + ordered[1] * 2) + (length * width * height)
            sum += (2 * length * width) + (2 * width * height) + (2 * height * length) + smallest
        }
        return mapOf("paper" to sum, "ribbon" to ribbon)
    }


    private fun parseInput(rawInput: String): List<List<Int>> {
        return rawInput.split('\n')
            .map { line: String ->
                line.split('x').map { it.toInt() }
            }
    }
}

