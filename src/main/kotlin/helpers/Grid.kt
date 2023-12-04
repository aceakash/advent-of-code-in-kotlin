package helpers


class Grid<T>(private val rows: List<List<T>>) {
    public val width: Int = rows[0].size

    public val height: Int = rows.size

}