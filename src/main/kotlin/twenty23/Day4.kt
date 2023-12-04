package twenty23

import helpers.parseIntList
import kotlin.math.pow

data class Card(val winningNums: List<Int>, val nums: List<Int>, var count: Int = 1)

class Day4 {
    fun part1(input: String): Int {
        val parsed: List<Card> = parseInput(input)

        return parsed.sumOf { card ->
            val matches = card.winningNums.toSet() intersect card.nums.toSet()

            if (matches.isEmpty()) 0
            else (2.0).pow(matches.size - 1.0).toInt()
        }
    }

    fun part2(input: String): Int {
        val cards = parseInput(input)

        cards.forEachIndexed { i, card ->
            val matchCount = card.winningNums.toSet().intersect(card.nums.toSet()).size
            for (j in 1..matchCount) {
                cards[i + j].count += card.count
            }
        }
        return cards.sumOf { it.count }
    }

    private fun parseInput(input: String): List<Card> {
        return input.split("\n").map { line ->
            val (winningNums, allNums) = line.substringAfter(":").split("|")
            Card(parseIntList(winningNums), parseIntList(allNums))
        }
    }
}