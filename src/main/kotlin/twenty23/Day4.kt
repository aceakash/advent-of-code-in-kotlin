package twenty23

import kotlin.math.pow


class Day4 {
    fun part1(input: String): Int {
        val parsed: List<Pair<List<Int>, List<Int>>> = parseInput(input)

        return parsed.map { card ->
            val matches = card.first.toSet().intersect(card.second.toSet())
            if (matches.isEmpty()){
                0
            } else {
                (2.0).pow(matches.size - 1.0).toInt()
            }
        }.sum()

    }

    private fun parseInput(input: String): List<Pair<List<Int>, List<Int>>> {
        return input.split("\n").map { line ->
            val parts = line.split(":")[1].split("|")
            Pair(parseNumList(parts[0]), parseNumList(parts[1]))
        }
    }

    private fun parseNumList(str: String): List<Int> {
        return str.trim().split("""\s+""".toRegex()).map {
            it.trim().toInt()
        }
    }




}