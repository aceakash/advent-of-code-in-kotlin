package twenty16

import kotlin.math.abs

data class Point2D(var x: Int = 0, var y: Int = 0) {
    fun addY(units: Int): Point2D {
        return Point2D(x, y + units)
    }

    fun addX(units: Int): Point2D {
        return Point2D(x + units, y)
    }
}

class Day1 {
    fun partOne(input: String): Int {
        var currPos = Point2D(0, 0)
        var currDir = "N"
        input.split(", ").forEach {
            val dir = it.take(1)
            val blocks = it.drop(1).toInt()

            // new dir
            currDir = getNewDir(currDir, dir)

            when (currDir) {
                "N" ->
                    currPos = currPos.addY(blocks)

                "S" ->
                    currPos = currPos.addY(-1 * blocks)

                "E" ->
                    currPos = currPos.addX(blocks)

                "W" ->
                    currPos = currPos.addX(-1 * blocks)
            }
        }

        return abs(currPos.x) + abs(currPos.y)
    }

    fun partTwo(input: String): Int {
        var currPos = Point2D(0, 0)
        var currDir = "N"
        val visited = mutableSetOf(currPos)
        input.split(", ").forEach {it ->
            val dir = it.take(1)
            val blocks = it.drop(1).toInt()

            // new dir
            currDir = getNewDir(currDir, dir)

            (1..blocks).forEach { _ ->
                val newPos = getUpdatedXY(currPos, currDir)
                if (newPos in visited) {
                    return abs(newPos.x) + abs(newPos.y)
                } else {
                    visited.add(newPos)
                    currPos = newPos
                }
            }
        }
        return -1
    }

    private fun getUpdatedXY(pos: Point2D, currDir: String): Point2D {
        return when (currDir) {
            "N" -> pos.addY(1)
            "S" -> pos.addY(-1)
            "E" -> pos.addX(1)
            "W" -> pos.addX(-1)
            else -> pos
        }
    }

    private fun getNewDir(currDir: String, moveDir: String): String {
        when (currDir) {
            "N" -> return if (moveDir == "L") "W" else "E"
            "S" -> return if (moveDir == "L") "E" else "W"
            "W" -> return if (moveDir == "L") "S" else "N"
            "E" -> return if (moveDir == "L") "N" else "S"
        }
        return ""
    }
}