package twenty23

class Day1 {
    fun part1(input: String): Int {
        return input
            .split("\n")
            .sumOf { line ->
                val nums = line.filter { it.isDigit() }
                "${nums.first()}${nums.last()}".toInt()
            }
    }


    fun part2(input: String): Int {
        return input
            .split("\n")
            .map {
                it
                    .replace("zero", "zero0zero")
                    .replace("one", "one1one")
                    .replace("two", "two2two")
                    .replace("three", "three3three")
                    .replace("four", "four4four")
                    .replace("five", "five5five")
                    .replace("six", "six6six")
                    .replace("seven", "seven7seven")
                    .replace("eight", "eight8eight")
                    .replace("nine", "nine9nine")
            }
            .sumOf { line ->
                val nums = line.filter { it.isDigit() }
                "${nums.first()}${nums.last()}".toInt()
            }
    }


}

fun Any?.println(): Unit {
    println(this)
}