package twenty23

class Day1 {
    fun part1(input: String): Int {
        val numChars = "0".."9"
        return input
            .split("\n")
            .map { line ->
            val first = line.find { c -> numChars.contains(c.toString()) }.toString().toInt()
            val last = line.findLast { c -> numChars.contains(c.toString()) }.toString().toInt()
            Pair(first, last)
        }
            .map { "${it.first}${it.second}".toInt() }
            .sum()
    }


    fun part2(input: String): Int {
        return input.length
    }


}