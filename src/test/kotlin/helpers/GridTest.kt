package helpers

import kotlin.test.*

class GridTest {

    @Test
    fun `can get height and width of a grid`() {
        val grid = Grid(listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        ))

        assertEquals(3, grid.width)
        assertEquals(2, grid.height)
    }

    @Test
    fun `gets value at cell using row-col position`() {
        val grid = Grid(listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        ))

        assertEquals(1, grid.cellAt(PosRC(0, 0)))
        assertEquals(2, grid.cellAt(PosRC(0, 1)))
        assertEquals(3, grid.cellAt(PosRC(0, 2)))
        assertEquals(4, grid.cellAt(PosRC(1, 0)))
        assertEquals(5, grid.cellAt(PosRC(1, 1)))
        assertEquals(6, grid.cellAt(PosRC(1, 2)))
    }

    @Test
    fun `gets null when non-existent row-col position specified`() {
        val grid = Grid(listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        ))

        assertEquals(null, grid.cellAt(PosRC(2, 0)))
        assertEquals(null, grid.cellAt(PosRC(2, 5)))
        assertEquals(null, grid.cellAt(PosRC(0, 5)))
    }

    @Test
    fun `gets row at specified index`() {
        val grid = Grid(listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6)
        ))

        assertEquals(listOf(1, 2, 3), grid.rowAt(0))
        assertEquals(listOf(4, 5, 6), grid.rowAt(1))
        assertEquals(emptyList(), grid.rowAt(2))
    }
}