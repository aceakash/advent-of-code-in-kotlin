package twenty23

class Day2 {
    fun part1(input: String): Int {
        val games = input.split("\n")
            .mapIndexed { i, l -> Game.fromString(i, l) }

        val maxCountsByColour = mapOf("red" to 12, "green" to 13, "blue" to 14)

        return games.filter { it.isPossible(maxCountsByColour) }
            .sumOf { it.gameNum }
    }

    fun part2(input: String): Int {
        val games = input.split("\n")
            .mapIndexed { i, l -> Game.fromString(i, l) }

        return games.sumOf {
            val maxByColour = it.getMaxRGB()
            (maxByColour.first * maxByColour.second * maxByColour.third)
        }
    }

    private data class Game(val gameNum: Int = 0, val sets: List<GameSet> = emptyList()) {
        companion object {
            fun fromString(index: Int, str: String): Game {
                val setInfo = str.split(": ")[1]
                val gameSets = setInfo.split("; ").map {
                    GameSet.fromString(it)
                }
                //        println("gameSets: $gameSets")
                return Game(index + 1, gameSets)
            }
        }

        fun isPossible(maxCountsByColour: Map<String, Int>): Boolean {
            return this.sets.all { it.isPossible(maxCountsByColour) }
        }

        fun getMaxRGB(): Triple<Int, Int, Int> {
            return Triple(
                sets.maxBy { set -> set.red }.red,
                sets.maxBy { set -> set.green }.green,
                sets.maxBy { set -> set.blue }.blue
            )
        }
        private data class GameSet(
            val red: Int = 0,
            val green: Int = 0,
            val blue: Int = 0,
        ) {
            fun isPossible(maxCountsByColour: Map<String, Int>): Boolean {
                return (this.red <= (maxCountsByColour["red"] ?: 0) // todo: use map with default
                        && this.green <= (maxCountsByColour["green"] ?: 0)
                        && this.blue <= (maxCountsByColour["blue"] ?: 0))
            }

//            private fun parseGameSetFromString(gameSetStr: String): GameSet {
////        println("gameSetStr: $gameSetStr")
//                val gameSetMap = mutableMapOf<String, Int>()
//                gameSetStr.split(", ").forEach {
//                    // x colour
//                    val parts = it.split(" ")
//                    gameSetMap[parts[1]] = parts[0].toInt()
//                }
//                return GameSet(gameSetMap["red"] ?: 0, gameSetMap["green"] ?: 0, gameSetMap["blue"] ?: 0)
//            }

            companion object {
                fun fromString(gameSetStr: String): GameSet {
                    val gameSetMap = mutableMapOf<String, Int>()
                    gameSetStr.split(", ").forEach {
                        // x colour
                        val parts = it.split(" ")
                        gameSetMap[parts[1]] = parts[0].toInt()
                    }
                    return GameSet(gameSetMap["red"] ?: 0, gameSetMap["green"] ?: 0, gameSetMap["blue"] ?: 0)
                }
            }

        }
    }
}

