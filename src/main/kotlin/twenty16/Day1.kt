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

            when (currDir) {
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

    fun partTwo(input: String): Int {
        var x = 0
        var y = 0
        var currDir = "N"
        val visited = mutableSetOf(x to y)
        input.split(", ").forEach {
            println("----instruction: $it")
            println("current direction: $currDir")
            println("current position: $x, $y")

            val dir = it.take(1)
            val blocks = it.drop(1).toInt()

            // new dir
            currDir = getNewDir(currDir, dir)
            println("new direction: $currDir")


            (1..blocks).forEach { it ->
                val (x1, y1) = getUpdatedXY(x, y, currDir)
                x = x1
                y = y1
                println("new position: $x, $y")
                if (Pair(x, y) in visited) {
                    return abs(x) + abs(y)
                } else {
                    visited.add(x to y)
                }
            }

        }
        return 99
    }

    private fun getUpdatedXY(x: Int, y: Int, currDir: String): Pair<Int, Int> {
        return when (currDir) {
            "N" ->
                x to y + 1

            "S" ->
                x to y - 1

            "E" ->
                x + 1 to y

            "W" ->
                x - 1 to y

            else ->
                x to y
        }


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