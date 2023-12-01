package twenty15

class Day5 {
    fun partOne(input: String): Int {
        val containsAtLeastThreeVowels = { str: String ->
            str.count { it in "aeiou" } >= 3
        }
        val containsAtLeastOneDoubleLetter = { str: String ->
            val doubles = str.dropLast(1)  // abccd -> abcc
                .mapIndexed { index, _ ->
                    setOf(str[index], str[index + 1]) // -> ab, bc, cc
                }
                .count { it.size == 1 }

            doubles > 0

        }

        val containsProhibitedString = { str: String ->
            str.contains("ab") || str.contains("cd") || str.contains("pq") || str.contains("xy")
        }


        return input.split("\n")
            .count {
                !containsProhibitedString(it)
                        && containsAtLeastThreeVowels(it)
                        && containsAtLeastOneDoubleLetter(it)
            }

    }

    fun partTwo(input: String): Int {
        return 0
    }


}
