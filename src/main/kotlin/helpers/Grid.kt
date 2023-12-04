package helpers


class Grid<T> {
    private val rows: List<List<T>>

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

    val width: Int

    val height: Int

}

fun <T> List<List<T>>.areAllSameSize(): Boolean {
    return this.map { it.size }.toSet().size == 1
}