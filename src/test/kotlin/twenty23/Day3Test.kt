package twenty23

import java.io.File
import kotlin.test.*


class Day3Test {

    @Test
    fun `part1 - simple input 1`() {
        assertEquals(59, Day3().part1("..*53.$4...2@"))
    }

    @Test
    fun `part1 - sample input 2`() {
        val input = """
467..114..
...*......
..35...633
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..
""".trimIndent()

        assertEquals(4361, Day3().part1(input))
    }

    @Test
    fun `part1 - test input 2`() {
        val input = """
.....180.........230...............
........*.602.........571-.........
..509.923.=....................+...
...*............273..........307...
.906..............*.350............
...............944.....*......473..
...........937........32........./.
....304....*...870.......*787......
...&......395...*.....545..........
""".trimIndent()

        assertEquals(9908, Day3().part1(input))
    }

    @Test
    fun `part1 - real input`() {
        assertEquals(537832, Day3().part1(realInput()))
    }

    private fun realInput(): String {
        return File("src/test/kotlin/twenty23/day3input.txt").readText().trim()
    }
}