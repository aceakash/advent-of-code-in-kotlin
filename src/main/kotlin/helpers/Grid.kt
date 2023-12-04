package helpers

class Grid private constructor(var cells: List<String>, val width: Int) {

    val height: Int
        get() {
            return cells.size/width
        }

    companion object {

        fun fromString(str: String, rowDelimiter: String ="\n"): Grid {
            val cells = mutableListOf<String>()
            var width = -1
            str.trim().split(rowDelimiter).forEach { rawRow ->
                val trimmed = rawRow.trim()
                width = trimmed.length
                trimmed.split("").forEach { c: String -> cells.add(c)}
            }
            println(cells)
            return Grid(cells, width)
        }

    }


}