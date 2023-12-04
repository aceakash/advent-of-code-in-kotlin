package helpers

class Grid<T> {
    private val rows: List<List<T>>

    val width: Int
    val height: Int

    constructor(rows: List<List<T>>) {
        assert(rows.isNotEmpty())
        assert(rows.all {it.isNotEmpty()})
        assert(rows.areAllSameSize())
        this.rows = rows
        this.width = rows[0].size
        this.height = rows.size
    }

    fun cellAt(posRC: PosRC): T? {
        val inRange = posRC.row in rows.indices && posRC.col in rows[0].indices
        if (!inRange) return null

        return rows[posRC.row][posRC.col]
    }

    fun rowAt(index: Int): List<T> {
        if (index !in rows.indices) return emptyList()

        return rows[index].toList()
    }

    fun getBorderPositionsForRowSection(start: PosRC, end: PosRC): Set<PosRC> {
        assert(start.row == end.row)
        val borderPositions = mutableSetOf<PosRC>()

        //top and bottom row
        for (i in start.col-1..end.col+1) {
            borderPositions.add(PosRC(start.row-1, i))
            borderPositions.add(PosRC(start.row+1, i))
        }
        // sides
        borderPositions.add(PosRC(start.row, start.col-1))
        borderPositions.add(PosRC(start.row, end.col + 1))

        return borderPositions
            .filterNot { pos -> pos.row < 0 || pos.row > rows.lastIndex }
            .filterNot { pos -> pos.col < 0 || pos.col > rows[0].lastIndex }
            .toSet()
    }
}

fun <T> List<List<T>>.areAllSameSize(): Boolean {
    return this.map { it.size }.toSet().size == 1
}