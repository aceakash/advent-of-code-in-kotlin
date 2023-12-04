package helpers

data class Point2D(var x: Int = 0, var y: Int = 0) {
    fun addY(units: Int): Point2D {
        return Point2D(x, y + units)
    }

    fun addX(units: Int): Point2D {
        return Point2D(x + units, y)
    }
}