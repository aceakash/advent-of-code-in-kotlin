package twenty23

import helpers.Grid
import helpers.PosRC


// the number, start pos and end pos in grid
typealias GridNumber = Triple<Int, PosRC, PosRC>

class Day3 {
    fun part1(input: String): Int {
        val grid: List<String> = input.split("\n")

        val symbolCheck: (Char) -> Boolean = { c: Char -> !c.isDigit() && c!='.'}

        return getAllNumbers(grid)
            .filter { isNextToSymbol(grid, it, symbolCheck) }
            .sumOf { it.first }
    }

    fun part2(input: String): Int {
        val grid: List<String> = input.split("\n")

        val mapOfGearToSurroundingNumbers = mutableMapOf<PosRC, MutableSet<GridNumber>>()

        getAllNumbers(grid).forEach { number: GridNumber ->
            getBorderPositionsForSeq(grid, number.second, number.third)
                .forEach { borderPos: PosRC ->
                if (grid[borderPos.row][borderPos.col] == '*') {
                    if (!mapOfGearToSurroundingNumbers.containsKey(borderPos)) {
                        mapOfGearToSurroundingNumbers[borderPos] = mutableSetOf()
                    }
                    mapOfGearToSurroundingNumbers[borderPos]?.add(number)
                }
            }
        }

        return mapOfGearToSurroundingNumbers.entries
            .filter { e -> e.value.size == 2 }
            .map { it.value.fold(1) { acc, next -> acc * next.first } }
            .sum()
    }


    private fun isNextToSymbol(grid: List<String>, gridNumber: GridNumber, symbolCheck: (Char) -> Boolean): Boolean {
        val borderPositions: List<PosRC> = getBorderPositionsForSeq(grid, gridNumber.second, gridNumber.third)
        return borderPositions.any { pos ->
            val charAtPos = grid[pos.row][pos.col]
            symbolCheck(charAtPos)
        }
    }

    // todo this is reusable
    private fun getBorderPositionsForSeq(grid: List<String>, start: PosRC, end: PosRC): List<PosRC> {
        val g = Grid(grid.map { it.trim().toCharArray().map { c -> c.toString() } })
        return g.getBorderPositionsForRowSection(start, end).toList()
    }

    private fun getNumbersFromRow(rowidx: Int, row: String): List<GridNumber> {
        val matches = """\d+""".toRegex().findAll(row)
        return matches.map { m ->
            GridNumber(m.value.toInt(), PosRC(rowidx, m.range.first), PosRC(rowidx, m.range.last))
        }.toList()
    }

    private fun getAllNumbers(grid: List<String>): List<GridNumber> {
        val numbers: List<List<GridNumber>> = grid.mapIndexed { rowidx, row -> getNumbersFromRow(rowidx, row) }
        return numbers.flatten()
    }

}