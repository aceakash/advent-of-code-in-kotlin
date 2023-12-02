package twenty23

class Day2 {
    enum class Colour(val maxValue: Int) { red(12), green(13), blue(14) }

    fun part1(input: String): Int {
//        val maxCountsByColour = mapOf("red" to 12, "green" to 13, "blue" to 14)

        return Game.parseMultipleGames(input)
            .filter { it.isPossible() }
            .sumOf { it.gameNum }
    }

    fun part2(input: String): Int {
        return Game.parseMultipleGames(input)
            .sumOf {
                val maxByColour = it.getMaxRGB()
                (maxByColour.first * maxByColour.second * maxByColour.third)
            }
    }

    private data class Game(val gameNum: Int = 0, val sets: List<GameSet> = emptyList()) {
        companion object {
            fun parseSingleGame(index: Int, str: String): Game {
                val gameSets = str.split(": ")[1]
                    .split("; ").map { GameSet.fromString(it) }
                return Game(index + 1, gameSets)
            }

            fun parseMultipleGames(str: String): List<Game> {
                return str.split("\n")
                    .mapIndexed { i, l -> parseSingleGame(i, l) }
            }
        }

        fun isPossible(): Boolean {
            return this.sets.all { it.isPossible() }
        }

        fun getMaxRGB(): Triple<Int, Int, Int> {
            return Triple(
                sets.maxBy { set -> set.redCount }.redCount,
                sets.maxBy { set -> set.greenCount }.greenCount,
                sets.maxBy { set -> set.blueCount }.blueCount
            )
        }

        private data class GameSet(
            val redCount: Int = 0,
            val greenCount: Int = 0,
            val blueCount: Int = 0,
        ) {
            fun isPossible(): Boolean {
                return (this.redCount <= Colour.red.maxValue
                        && this.greenCount <= Colour.green.maxValue
                        && this.blueCount <= Colour.blue.maxValue)
            }

            companion object {
                fun fromString(gameSetStr: String): GameSet {
                    val gameSetMap = mutableMapOf<String, Int>()
                    gameSetStr.split(", ").forEach {
                        val parts = it.split(" ")
                        gameSetMap[parts[1]] = parts[0].toInt()
                    }
                    return GameSet(gameSetMap["red"] ?: 0, gameSetMap["green"] ?: 0, gameSetMap["blue"] ?: 0)
                }
            }
        }
    }
}

