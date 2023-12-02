package twenty23

import kotlin.test.*


class Day2Test {

    @Test
    fun `part1 - sample input`() {
        val input = """
Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
""".trimIndent()

        assertEquals(8, Day2().part1(input))
    }

    @Test
    fun `part1 - single game input`() {
        val input = """
Game 1: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
""".trimIndent()

        assertEquals(1, Day2().part1(input))
    }
    @Test
    fun `part1 - simplest game`() {
        val input = """
Game 1: 6 red, 1 blue, 3 green
""".trimIndent()

        assertEquals(1, Day2().part1(input))
    }

    @Test
    fun `part1 - real input`() {

        assertEquals(2176, Day2().part1(realInput()))
    }





    private fun realInput(): String {
        return """
            Game 1: 4 green, 2 blue; 1 red, 1 blue, 4 green; 3 green, 4 blue, 1 red; 7 green, 2 blue, 4 red; 3 red, 7 green; 3 red, 3 green
            Game 2: 1 blue, 11 red, 1 green; 3 blue, 2 red, 4 green; 11 red, 2 green, 2 blue; 13 green, 5 red, 1 blue; 4 green, 8 red, 3 blue
            Game 3: 9 red, 2 blue; 4 blue, 2 green, 1 red; 7 red, 4 blue, 3 green; 3 blue, 6 red; 9 blue, 4 red; 3 red
            Game 4: 5 blue, 11 green, 3 red; 6 green, 3 blue, 7 red; 17 blue, 9 green; 1 red, 5 blue, 3 green; 6 red, 7 blue, 4 green
            Game 5: 3 green, 7 blue, 7 red; 6 green, 3 red, 4 blue; 7 blue, 4 red
            Game 6: 1 green, 3 blue; 2 blue, 9 red; 2 green, 13 blue, 11 red; 7 red, 12 blue, 1 green
            Game 7: 2 blue, 6 red, 12 green; 7 red, 8 blue, 6 green; 7 blue, 3 green, 7 red; 5 blue, 9 green, 13 red
            Game 8: 13 blue, 1 green; 3 red, 9 blue; 3 red, 4 blue; 2 red, 3 blue, 1 green; 1 green, 15 blue, 4 red
            Game 9: 1 green, 5 blue, 11 red; 2 red, 1 blue; 2 red, 5 blue
            Game 10: 8 red, 20 green; 12 green, 1 red, 2 blue; 5 red, 3 blue, 7 green; 4 red, 19 green, 6 blue; 3 blue, 4 red, 14 green; 9 red, 15 green
            Game 11: 7 green, 4 blue, 14 red; 7 red, 8 green; 6 blue, 6 red; 5 blue, 10 red, 11 green; 12 red, 2 green
            Game 12: 4 blue, 5 green, 8 red; 2 green, 4 blue, 7 red; 4 blue, 3 green, 2 red; 2 red, 4 green
            Game 13: 7 blue, 8 red; 5 green, 15 blue, 2 red; 7 green, 3 blue, 12 red
            Game 14: 4 green, 16 red; 6 red, 2 green; 5 red, 1 blue, 3 green; 1 blue, 1 red, 2 green
            Game 15: 3 green; 2 blue, 1 red, 2 green; 6 blue; 3 blue, 1 red, 2 green; 2 red, 1 green
            Game 16: 13 green, 3 red; 9 green, 1 blue; 4 blue, 1 red, 18 green; 2 red, 3 blue, 7 green; 17 green, 2 red, 3 blue; 12 green, 2 red
            Game 17: 2 blue, 4 green, 3 red; 2 red, 5 green, 11 blue; 5 green, 15 blue, 2 red; 3 green, 13 blue; 6 blue, 2 green, 2 red; 8 blue, 1 red
            Game 18: 6 red, 4 green, 7 blue; 2 red, 3 green, 12 blue; 3 red, 6 blue, 6 green; 9 red, 10 blue; 6 green, 4 blue, 2 red; 12 red, 12 blue, 9 green
            Game 19: 3 blue, 2 red, 3 green; 16 red, 3 blue, 5 green; 2 red, 6 green; 3 green, 2 blue, 15 red; 2 blue, 13 red, 1 green
            Game 20: 2 blue; 1 green, 5 blue, 2 red; 3 blue, 2 red, 1 green; 1 red, 2 blue
            Game 21: 15 green, 13 blue, 4 red; 9 green, 6 red, 19 blue; 6 blue, 1 green, 1 red; 1 red, 11 green, 9 blue; 3 red, 14 green, 8 blue
            Game 22: 3 blue, 10 red, 1 green; 2 red, 6 green; 9 green, 3 blue, 4 red; 2 blue, 4 green
            Game 23: 5 red, 2 green, 5 blue; 4 green, 12 red, 2 blue; 3 green, 8 red, 4 blue
            Game 24: 1 green, 16 red, 3 blue; 10 red, 1 blue; 2 blue, 1 green, 7 red; 12 red, 1 green; 14 red, 1 green; 1 blue, 8 red, 1 green
            Game 25: 8 blue, 9 red, 6 green; 2 blue, 4 green, 8 red; 1 green, 9 blue, 2 red; 14 red, 4 blue
            Game 26: 4 blue, 3 green; 1 red, 3 blue; 6 red, 2 green, 6 blue; 5 green, 2 red; 5 blue, 5 green; 6 red, 1 blue
            Game 27: 6 green, 9 blue; 1 red, 6 green, 8 blue; 3 green, 1 blue, 1 red; 3 red, 4 blue; 2 red, 2 blue; 4 red, 3 green, 7 blue
            Game 28: 5 green, 2 blue; 5 blue; 1 red, 4 blue, 3 green; 1 green, 2 red
            Game 29: 1 green, 2 red, 4 blue; 1 green, 2 red, 1 blue; 9 red, 6 blue
            Game 30: 1 green, 1 red, 5 blue; 13 blue, 4 green, 2 red; 10 green, 11 blue; 9 green, 2 red, 12 blue
            Game 31: 4 red, 5 blue; 8 blue, 1 red, 1 green; 4 red, 5 green; 3 green; 9 blue, 2 red, 7 green
            Game 32: 5 blue, 4 red, 5 green; 10 red, 10 green, 5 blue; 10 red, 12 green, 6 blue; 8 red, 1 blue, 13 green; 6 green, 14 red, 2 blue
            Game 33: 9 green, 6 red, 4 blue; 1 red, 2 blue, 13 green; 4 red, 4 green, 5 blue
            Game 34: 1 blue, 1 red; 9 green, 14 red, 1 blue; 3 blue, 7 green
            Game 35: 1 red, 11 green, 5 blue; 1 red, 5 blue, 17 green; 19 green, 6 blue; 4 green, 7 blue; 10 blue, 7 green
            Game 36: 9 green, 6 blue, 4 red; 8 blue, 13 green, 1 red; 5 blue, 5 green; 15 green, 1 red
            Game 37: 1 green, 9 red, 1 blue; 14 green; 11 green, 6 red
            Game 38: 2 blue; 9 green, 1 blue, 8 red; 4 green, 1 blue, 3 red
            Game 39: 7 red, 7 blue; 3 green, 6 blue, 2 red; 3 green, 4 red
            Game 40: 5 blue, 2 red, 6 green; 6 blue, 10 green, 4 red; 8 green, 6 blue; 3 green, 2 blue; 2 red, 14 green
            Game 41: 5 red, 14 blue, 3 green; 3 red, 3 blue, 7 green; 19 blue, 15 green, 6 red; 5 green, 18 blue; 1 green, 7 red, 9 blue; 14 green, 10 blue, 1 red
            Game 42: 2 red, 3 green; 2 blue, 3 red; 15 green, 1 blue; 2 blue, 15 green, 1 red; 7 red, 15 green
            Game 43: 4 green, 6 red, 9 blue; 4 green, 3 red, 18 blue; 6 green, 7 blue; 4 red, 7 blue; 8 blue, 7 green, 1 red; 5 red, 14 blue
            Game 44: 2 green, 11 blue; 1 green, 5 red, 8 blue; 4 green, 17 blue, 4 red
            Game 45: 6 blue, 3 green, 2 red; 8 green, 12 blue, 3 red; 13 blue, 11 green; 13 blue, 9 green; 2 blue, 3 green, 3 red; 2 blue, 10 green
            Game 46: 14 blue, 12 green, 3 red; 2 green, 1 red, 10 blue; 5 red, 7 green
            Game 47: 15 blue, 1 red; 1 red, 14 blue; 1 red, 16 blue; 3 green, 8 blue
            Game 48: 1 green, 3 blue, 1 red; 8 blue, 2 red, 8 green; 14 red, 4 green, 11 blue
            Game 49: 6 red, 5 blue, 2 green; 3 red, 11 blue; 1 blue, 14 green, 6 red
            Game 50: 7 red, 7 blue; 7 blue, 7 red; 13 blue, 1 green, 2 red; 7 green, 5 red, 9 blue
            Game 51: 4 blue, 9 red, 1 green; 16 red; 2 blue, 6 red; 11 red, 6 blue
            Game 52: 4 green, 4 blue, 9 red; 5 blue, 4 red, 16 green; 16 green, 3 red
            Game 53: 2 green, 12 red; 2 red, 5 green, 15 blue; 9 blue, 17 red, 9 green; 2 blue, 6 red, 4 green
            Game 54: 2 red, 3 blue, 5 green; 8 green, 3 blue; 9 green, 3 blue, 3 red; 1 blue, 4 green
            Game 55: 6 green, 11 blue, 12 red; 10 blue, 6 red, 13 green; 7 green, 9 blue; 10 green, 20 red, 7 blue; 9 green, 14 red, 8 blue; 14 green, 15 red
            Game 56: 1 green, 8 red, 1 blue; 1 green, 3 blue, 13 red; 5 red, 3 blue; 5 blue, 16 red; 12 red, 4 blue
            Game 57: 7 green, 5 blue; 13 blue; 1 red, 11 green, 4 blue; 1 red, 7 green, 5 blue
            Game 58: 14 blue, 6 green, 9 red; 7 blue, 1 green, 11 red; 3 red, 9 blue, 6 green; 4 green, 2 red; 2 blue, 6 green; 11 blue, 1 red
            Game 59: 6 red, 1 blue, 5 green; 4 green; 15 green; 7 red, 1 blue, 12 green; 7 red, 1 blue, 3 green
            Game 60: 3 blue, 6 red, 2 green; 7 green, 6 red, 4 blue; 3 green, 1 red, 4 blue; 3 red, 1 green; 9 red, 5 green, 4 blue
            Game 61: 1 green, 3 blue; 1 red, 2 green; 1 green, 2 blue, 2 red
            Game 62: 10 green, 15 blue, 14 red; 11 blue, 11 red, 16 green; 5 red, 5 green, 12 blue
            Game 63: 2 blue, 5 red; 7 blue, 2 green, 2 red; 2 red, 1 blue
            Game 64: 9 blue, 12 red, 4 green; 5 blue, 13 red; 1 red, 2 green, 7 blue
            Game 65: 4 blue, 8 red; 13 green, 8 blue, 5 red; 1 green, 5 blue, 7 red; 11 red, 7 blue, 10 green
            Game 66: 8 red, 17 blue; 1 green, 9 red, 7 blue; 12 red
            Game 67: 14 blue, 12 green, 3 red; 12 green; 9 green, 13 red, 15 blue; 2 red, 10 green, 1 blue
            Game 68: 11 blue, 14 green; 14 green; 9 blue, 7 green, 1 red; 9 blue, 7 green; 17 green, 2 blue; 4 green, 4 blue
            Game 69: 4 blue, 14 green, 6 red; 11 red, 7 green, 10 blue; 4 red, 8 blue, 8 green; 7 green, 6 red, 7 blue
            Game 70: 12 red, 16 green, 11 blue; 16 green, 15 blue, 5 red; 10 blue, 1 red, 12 green; 9 red, 8 blue, 4 green; 2 green, 8 red, 3 blue
            Game 71: 8 red, 1 blue, 5 green; 12 green, 7 red; 11 green, 1 blue, 7 red
            Game 72: 5 green, 15 red; 7 green, 3 red, 4 blue; 10 red, 1 green; 6 blue, 15 red, 3 green
            Game 73: 1 green, 5 red, 1 blue; 6 red, 3 blue, 6 green; 11 red, 1 blue
            Game 74: 5 red; 1 blue, 3 green, 3 red; 2 green, 7 red; 1 blue, 2 red; 3 red, 1 green
            Game 75: 13 blue, 20 red, 10 green; 3 green, 5 blue, 14 red; 9 red, 13 green, 7 blue; 1 blue, 15 red, 2 green; 11 blue, 2 green, 17 red; 11 red, 13 blue, 13 green
            Game 76: 9 red, 7 green, 2 blue; 7 red, 2 blue, 8 green; 4 blue, 3 red, 9 green; 4 red, 1 green; 1 red, 2 green, 3 blue
            Game 77: 5 red, 2 green, 15 blue; 12 green, 4 red, 2 blue; 10 blue, 6 red, 9 green; 7 blue, 3 green; 16 blue, 4 red, 5 green
            Game 78: 11 blue, 3 green, 19 red; 3 blue, 1 red; 8 red, 14 blue, 3 green; 8 blue, 8 green, 16 red; 8 blue, 14 red; 12 blue, 11 red, 2 green
            Game 79: 10 blue, 5 red, 1 green; 3 blue, 13 red; 15 red, 1 green; 4 red, 6 blue, 1 green; 1 green, 6 blue
            Game 80: 7 red, 1 green, 1 blue; 1 blue, 4 red, 3 green; 2 red, 2 green; 7 red, 1 blue, 1 green; 2 red, 1 green, 3 blue
            Game 81: 12 green, 2 red, 8 blue; 1 green, 1 blue, 1 red; 7 blue, 1 red, 11 green; 1 red, 12 blue, 4 green
            Game 82: 18 red, 5 blue, 4 green; 6 green, 11 red; 11 green, 18 red, 5 blue; 4 green, 17 red, 4 blue; 5 blue, 14 red, 15 green
            Game 83: 4 red, 6 blue, 6 green; 9 red, 4 green; 8 green, 7 blue; 2 blue, 9 red, 13 green; 2 blue, 9 green, 11 red
            Game 84: 15 blue; 4 green, 1 red, 15 blue; 2 green, 16 blue; 3 green, 14 blue; 16 blue
            Game 85: 3 red, 7 green, 8 blue; 3 blue, 17 green, 7 red; 13 green, 4 blue; 6 blue, 8 green
            Game 86: 16 green, 6 blue; 12 blue, 9 red, 11 green; 17 green, 4 blue, 8 red
            Game 87: 6 blue, 3 green, 13 red; 13 blue; 12 red, 2 green, 1 blue
            Game 88: 6 red, 2 blue; 16 red, 13 blue, 1 green; 2 green, 11 blue, 2 red; 12 blue, 9 red, 1 green; 5 blue, 2 red, 2 green; 18 red, 3 blue
            Game 89: 6 green, 5 blue; 4 green, 4 blue; 3 red, 5 blue
            Game 90: 3 green, 8 blue; 2 green, 7 blue, 9 red; 8 red, 2 blue, 4 green; 1 green, 3 red, 7 blue; 4 blue, 4 green, 2 red; 9 red, 3 blue, 3 green
            Game 91: 9 red, 12 green, 1 blue; 11 green, 9 red, 2 blue; 1 blue, 8 red, 4 green; 6 red, 9 green; 2 blue, 10 red, 1 green; 2 blue, 15 green, 13 red
            Game 92: 3 green, 11 red, 16 blue; 8 blue, 1 red, 6 green; 4 green, 1 red, 5 blue
            Game 93: 9 blue, 3 red, 13 green; 2 red, 9 blue; 3 blue, 17 green, 5 red; 4 green, 8 blue
            Game 94: 2 blue, 3 red, 9 green; 4 blue, 1 red, 6 green; 8 green, 2 blue; 4 green, 2 blue, 7 red
            Game 95: 5 green, 3 blue; 4 blue, 3 green, 8 red; 3 green, 4 red, 3 blue; 2 blue, 4 red; 9 blue, 5 red, 3 green
            Game 96: 11 green; 10 green, 5 blue, 11 red; 5 blue, 13 red, 15 green; 10 green, 1 blue, 11 red
            Game 97: 5 green, 6 blue, 1 red; 7 green, 1 red; 5 blue; 3 blue, 1 red
            Game 98: 1 blue, 5 green, 7 red; 3 red, 5 green, 1 blue; 4 blue, 8 green, 2 red; 4 green, 1 blue, 6 red
            Game 99: 12 blue, 8 green; 2 green; 3 red, 7 green, 5 blue; 1 green, 1 blue, 2 red
            Game 100: 4 blue, 14 red; 12 red, 1 blue; 2 red, 2 blue; 8 red; 14 red, 2 blue, 1 green; 3 blue
        """.trimIndent()
    }
}