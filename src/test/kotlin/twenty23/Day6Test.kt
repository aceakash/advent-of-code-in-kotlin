package twenty23

import kotlin.test.*


class Day6Test {

    @Test
    fun `part1 - sample input`() {
        val input = listOf(
            7 to 9,
            15 to 40,
            30 to 200,
        )
        assertEquals(288, Day6().part1(input))
    }

    @Test
    fun `part 1 - real input`() {
        assertEquals(140220, Day6().part1(realInput()))
    }





    private fun realInput(): List<Pair<Int, Int>> {
        return listOf(
            53 to 333,
            83 to 1635,
            72 to 1289,
            88 to 1532
        )
    }
}