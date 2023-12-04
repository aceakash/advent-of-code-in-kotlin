package helpers

import kotlin.test.*

class GridTest {

    @Test
    fun `can get height and width of a grid`() {
        val grid = Grid<Int>(listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        ))

        assertEquals(3, grid.width)
        assertEquals(2, grid.height)
    }
}