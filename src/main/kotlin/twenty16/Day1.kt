package twenty16

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
        val r = Rover()
        val visited = mutableSetOf(r.pos)
        input.split(", ").forEach {
            val turnDir = it.first()
            val blocks = it.drop(1).toInt()

            if (turnDir == 'R') r.turnRight() else r.turnLeft()

            (1..blocks).forEach { _ ->
                r.move(1)
                if (r.pos in visited) {
                    return abs(r.pos.x) + abs(r.pos.y)
                } else {
                    visited.add(r.pos)
                }
            }
        }
        return -1
    }
}