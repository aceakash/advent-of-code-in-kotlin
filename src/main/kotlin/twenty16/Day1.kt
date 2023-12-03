package twenty16

import kotlin.math.abs

class Day1 {

    fun partOne(input: String): Int {
        var x = 0
        var y = 0
        var currDir = "N"
        input.split(", ").forEach {
            val dir = it.take(1)
            val blocks = it.drop(1).toInt()

            // new dir
            currDir = getNewDir(currDir, dir)

            when(currDir) {
                "N" ->
                    y += blocks
                "S" ->
                    y -= blocks
                "E" ->
                    x += blocks
                "W" ->
                    x -= blocks
            }
        }

        return abs(x) + abs(y)
    }

    private fun getNewDir(currDir: String, moveDir: String): String {
        when (currDir) {
            "N" ->
                return if (moveDir == "L") "W" else "E"
            "S" ->
                return if (moveDir == "L") "E" else "W"
            "W" ->
                return if (moveDir == "L") "S" else "N"
            "E" ->
                return if (moveDir == "L") "N" else "S"
        }
        return ""
    }


}
