package twenty23

import java.time.LocalDateTime

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

        return seeds.map { findLocationForSeed(it, stages) }.min()
    }

    private fun findLocationForSeed(seed: Long, stages: List<Stage>): Long {
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
        return seq[Location] ?: -1
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

    private fun parseInitialSeedsAsRanges(input: String): List<LongRange> {
        val nums = parseInitialSeeds(input)

        val seedRanges = mutableListOf<LongRange>()
        var startOfRange = -1L
        for (i in nums.indices) {
            if (i % 2 == 1) {
                seedRanges.add(LongRange(startOfRange, startOfRange + nums[i] - 1))
                continue
            }
            startOfRange = nums[i]
        }
        return seedRanges
    }


    fun part2(input: String): Long {
        val seedRanges = parseInitialSeedsAsRanges(input)
        seedRanges.println()
        val stages = parseStages(input)

        var smallestLocation = Long.MAX_VALUE

        for (seedRange in seedRanges) {
            println("Starting seedRange: $seedRange at ${LocalDateTime.now()}")
            for (seed in seedRange) {
                val loc = findLocationForSeed(seed, stages)
                if (loc < smallestLocation) {
                    smallestLocation = loc
                }
            }
            println("Finished seedRange: $seedRange. Smallest location so far: $smallestLocation")
        }
        return smallestLocation
    }
}