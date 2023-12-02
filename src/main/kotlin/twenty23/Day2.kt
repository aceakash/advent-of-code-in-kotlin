package twenty23

class Day2 {
//    private data class Game(val gameNum: Int, val red: Int, val green: Int, val blue: Int)

    private data class Game(
        val gameNum: Int = 0,
        val sets: List<GameSet> = emptyList()
    ) {
        fun isPossible(maxCountsByColour: Map<String, Int>): Boolean {
            return this.sets.all { it.isPossible(maxCountsByColour) }
        }
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
    }


    fun part1(input: String): Int {
        // parse input
        val games = input.split("\n")
            .mapIndexed { i, l -> parseInputLine(i, l) }

        // business logic
        val maxCountsByColour = mapOf("red" to 12, "green" to 13, "blue" to 14)
        val sum = games.filter { it.isPossible(maxCountsByColour) }
            .sumOf { it.gameNum }


        return sum
    }

    private fun parseInputLine(index: Int, line: String): Game {
        val setInfo = line.split(": ")[1]
        val gameSets = setInfo.split("; ").map(::parseGameSetFromString)
//        println("gameSets: $gameSets")
        return Game(index + 1, gameSets)
    }

    private fun parseGameSetFromString(gameSetStr: String): GameSet {
//        println("gameSetStr: $gameSetStr")
        val gameSetMap = mutableMapOf<String, Int>()
        gameSetStr.split(", ").forEach {
            // x colour
            val parts = it.split(" ")
            gameSetMap[parts[1]] = parts[0].toInt()
        }
        return GameSet(gameSetMap["red"] ?: 0, gameSetMap["green"] ?: 0, gameSetMap["blue"] ?: 0)
    }


//    private fun parseLine(gameNum: Int, inputLine: String): List<Game> {
//        val par = inputLine.split(": ")
//        colonParts.println()
//        // Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
//
//        return
//    }
}

