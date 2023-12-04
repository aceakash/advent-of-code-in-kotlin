package helpers

data class Rover(var pos: Point2D = Point2D(), var heading: Dir = Dir.N) {
    fun turnRight() {
        heading = when(heading) {
            Dir.N -> Dir.E
            Dir.S -> Dir.W
            Dir.E -> Dir.S
            Dir.W -> Dir.N
        }
     }

    fun turnLeft() {
        heading = when(heading) {
            Dir.N -> Dir.W
            Dir.S -> Dir.E
            Dir.E -> Dir.N
            Dir.W -> Dir.S
        }
     }

    fun move(units: Int) {
        pos = when (heading) {
            Dir.N ->
                pos.addY(units)

            Dir.S ->
                pos.addY(-1 * units)

            Dir.E ->
                pos.addX(units)

            Dir.W ->
                pos.addX(-1 * units)
        }
    }
}