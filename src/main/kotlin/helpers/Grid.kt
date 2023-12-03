package helpers

class Grid private constructor(var cells: List<String>, val width: Int) {
    companion object {

        fun fromString(str: String, rowDelimiter: String ="\n"): Grid {
            val cells = mutableListOf<String>()
            var width = -1
            str.split(rowDelimiter).forEach { rawRow ->
                width = rawRow.length
                rawRow.split("").forEach { c: String -> cells.add(c)}
            }
            return Grid(cells, width)
        }

    }


}