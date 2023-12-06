package twenty23

const val Seed = "seed"
const val Soil = "soil"
const val Fertiliser = "fertiliser"
const val Water = "water"
const val Light = "light"
const val Temp = "temp"
const val Humidity = "humidity"
const val Location = "location"


class Day5 {
    data class Stage(var srcName: String, var destName: String, var mapRanges: Set<MapRange>)

    data class MapRange(val destStart: Long, val srcStart: Long, val rangeLength: Long)

    fun part1(input: String): Long {
        val seeds = parseInitialSeeds(input)
        val stages = parseStages(input)

        val sequencesForSeeds = seeds.map { seed ->
            val seq = mutableMapOf(
                Seed to -1L,
                Soil to -1L,
                Fertiliser to -1L,
                Water to -1L,
                Light to -1L,
                Temp to -1L,
                Humidity to -1L,
                Location to -1L
            )
            seq[Seed] = seed
            var currVal = seed
            for (key in seq.keys.drop(1)) {
                val nextVal = lookup(currVal, stages.find { it.destName == key }?.mapRanges)
                seq[key] = nextVal
                currVal = nextVal
            }
            seq
        }
        return sequencesForSeeds.minOfOrNull { it[Location]!!.toLong() } ?: -1
    }

    private fun lookup(currVal: Long, mapRanges: Set<MapRange>?): Long {
        if (mapRanges == null) throw IllegalArgumentException("mapRanges is not supposed to be null")

        mapRanges.forEach { m ->
            val srcRange = m.srcStart..<m.srcStart + m.rangeLength
            if (currVal in srcRange) {
                return m.destStart + (currVal - m.srcStart)
            }
        }
        return currVal
    }

    private fun parseStages(input: String): List<Stage> {
        val sources = listOf(Seed, Soil, Fertiliser, Water, Light, Temp, Humidity, Location)
        val mapStrings = input.trim().split("\n\n").drop(1)

        val stages = mutableListOf<Stage>()
        for (i in sources.dropLast(1).indices) {
            val source = sources[i]
            val rangeLines = mapStrings[i].substringAfter(":").trim().split("\n")
            val ranges = rangeLines.map { rl ->
                val nums = rl.split(" ").map { it.toLong() }
                MapRange(nums[0], nums[1], nums[2])
            }
            stages.add(Stage(source, sources[i + 1], ranges.toSet()))
        }
        return stages
    }

    private fun parseInitialSeeds(input: String): List<Long> {
        return input.trim()
            .split("\n\n")[0]
            .substringAfter("seeds: ")
            .split(" ")
            .map { it.toLong() }
    }


    fun part2(input: String): Int {
        return 1
    }
}