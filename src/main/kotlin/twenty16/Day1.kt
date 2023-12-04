package twenty16

import helpers.Dir
import helpers.Point2D
import helpers.Rover
import kotlin.math.abs

class Day1 {
    fun partOne(input: String): Int {
        val r = Rover()
        input.split(", ").forEach {
            val turnDir = it.first()
            val blocks = it.drop(1).toInt()
            if (turnDir == 'R') r.turnRight() else r.turnLeft()
            r.move(blocks)
        }
        return abs(r.pos.x) + abs(r.pos.y)
    }

    fun partTwo(input: String): Int {
        var currPos = Point2D(0, 0)
        var currDir = Dir.N
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

    private fun getUpdatedXY(pos: Point2D, currDir: Dir): Point2D {
        return when (currDir) {
            Dir.N -> pos.addY(1)
            Dir.S -> pos.addY(-1)
            Dir.E -> pos.addX(1)
            Dir.W -> pos.addX(-1)
        }
    }

    private fun getNewDir(currDir: Dir, moveDir: String): Dir {
        return when (currDir) {
            Dir.N -> if (moveDir == "L") Dir.W else Dir.E
            Dir.S -> if (moveDir == "L") Dir.E else Dir.W
            Dir.W -> if (moveDir == "L") Dir.S else Dir.N
            Dir.E -> if (moveDir == "L") Dir.N else Dir.S
        }
    }
}