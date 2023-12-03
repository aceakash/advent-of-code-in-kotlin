package twenty23

data class Pos(val row: Int = 0, val col: Int = 0)

// the number, start pos and end pos in grid
typealias GridNumber = Triple<Int, Pos, Pos>

class Day3 {
    fun part1(input: String): Int {
        val grid: List<String> = input.split("\n")

        return getAllNumbers(grid)
            .filter { isNextToSymbol(grid, it) }
            .sumOf { it.first }
    }

    private fun isNextToSymbol(grid: List<String>, gridNumber: GridNumber): Boolean {
        val borderPositions: List<Pos> = getBorderPositionsForSeq(grid, gridNumber.second, gridNumber.third)
        return borderPositions.any { pos ->
            val charAtPos = grid[pos.row][pos.col]
            !charAtPos.isDigit() && charAtPos!='.'
        }
    }

    // todo this is reusable
    private fun getBorderPositionsForSeq(grid: List<String>, start: Pos, end: Pos): List<Pos> {
        assert(start.row == end.row)
        val borderPositions = mutableListOf<Pos>()

        //top and bottom row
        for (i in start.col-1..end.col+1) {
            borderPositions.add(Pos(start.row-1, i))
            borderPositions.add(Pos(start.row+1, i))
        }
        // sides
        borderPositions.add(Pos(start.row, start.col-1))
        borderPositions.add(Pos(start.row, end.col + 1))

        return borderPositions
            .filterNot { pos -> pos.row < 0 || pos.row > grid.lastIndex }
            .filterNot { pos -> pos.col < 0 || pos.col > grid[0].lastIndex }
    }

    private fun getNumbersFromRow(rowidx: Int, row: String): List<GridNumber> {
        // start scanning
        var inScan = false
        var startPos: Int? = null
        var endPos: Int? = null
        val gridnums = mutableListOf<GridNumber>()
        for (i in row.indices) {
            if (!inScan) {
                if (row[i].isDigit()) {
                    inScan = true
                    startPos = i
                    endPos = i
                    continue
                }
                continue
            }
            if (row[i].isDigit()) {
                endPos = i
                continue
            }
            // in-scan and not a digit
            gridnums.add(GridNumber(row.substring(startPos!!, endPos!!+1).toInt(), Pos(rowidx, startPos), Pos(rowidx, endPos)))
            inScan = false
            startPos = null
            endPos = null
        }
        if (inScan) {
            gridnums.add(GridNumber(row.substring(startPos!!, endPos!!+1).toInt(), Pos(rowidx, startPos), Pos(rowidx, endPos)))
        }

        return gridnums
    }

    private fun getAllNumbers(grid: List<String>): List<GridNumber> {
        val numbers: List<List<GridNumber>> = grid.mapIndexed { rowidx, row -> getNumbersFromRow(rowidx, row) }
        return numbers.flatten()
    }
}