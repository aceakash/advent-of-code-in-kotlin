package twenty23

import kotlin.test.*


class Day6Test {

    @Test
    fun `part1 - sample input`() {
        val input = listOf(
            7L to 9L,
            15L to 40L,
            30L to 200L,
        )
        assertEquals(288, Day6().part1(input))
    }

    @Test
    fun `part 1 - real input`() {
        assertEquals(140220, Day6().part1(realInput1()))
    }

    @Test
    fun `part2 - sample input`() {
        val input = listOf(
            71530L to 940200L,
        )
        assertEquals(71503, Day6().part2(input))
    }

    @Test
    fun `part 2 - real input`() {
        assertEquals(39570185, Day6().part2(realInput2()))
    }

    private fun realInput1(): List<Pair<Long, Long>> {
        return listOf(
            53L to 333L,
            83L to 1635L,
            72L to 1289L,
            88L to 1532L
        )
    }

    private fun realInput2(): List<Pair<Long, Long>> {
        return listOf(
            53837288L to 333163512891532L,
        )
    }
}