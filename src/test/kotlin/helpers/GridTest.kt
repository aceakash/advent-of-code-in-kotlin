package helpers

import kotlin.test.*

class GridTest {

    @Test
    fun `can parse a grid from a string`() {
        val grid = Grid.fromString("""
            .1.
            2..
            ..3
        """.trimIndent())

        assertEquals(3, grid.width)
        assertEquals(3, grid.height)
    }
}