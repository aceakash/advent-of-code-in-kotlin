package helpers

/**
 * x along X axis (horizontal) increases left to right
 * y along Y axis (vertical) increased bottom to top
 */
data class PosXY(var x: Int = 0, var y: Int = 0) {
    fun addY(units: Int): PosXY {
        return PosXY(x, y + units)
    }

    fun addX(units: Int): PosXY {
        return PosXY(x + units, y)
    }
}