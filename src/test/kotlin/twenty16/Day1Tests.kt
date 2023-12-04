package twenty16

import kotlin.test.*

class Day1Tests {

    @Test
    fun `part 1 - real input`() {
        assertEquals(299, Day1().partOne(realInput()))
    }

    @Test
    fun `part 1 - sample moves`() {
        assertEquals(5, Day1().partOne("R2, L3"))
        assertEquals(2, Day1().partOne("R2, R2, R2"))
        assertEquals(12, Day1().partOne("R5, L5, R5, R3"))
    }

    @Test
    fun `part 2 - sample input`() {
        assertEquals(4, Day1().partTwo("R8, R4, R4, R8"))
    }
    @Test
    fun `part 2 - real input`() {
        assertEquals(181, Day1().partTwo(realInput()))
    }

    fun realInput(): String {
        return """
            L1, L3, L5, L3, R1, L4, L5, R1, R3, L5, R1, L3, L2, L3, R2, R2, L3, L3, R1, L2, R1, L3, L2, R4, R2, L5, R4, L5, R4, L2, R3, L2, R4, R1, L5, L4, R1, L2, R3, R1, R2, L4, R1, L2, R3, L2, L3, R5, L192, R4, L5, R4, L1, R4, L4, R2, L5, R45, L2, L5, R4, R5, L3, R5, R77, R2, R5, L5, R1, R4, L4, L4, R2, L4, L1, R191, R1, L1, L2, L2, L4, L3, R1, L3, R1, R5, R3, L1, L4, L2, L3, L1, L1, R5, L4, R1, L3, R1, L2, R1, R4, R5, L4, L2, R4, R5, L1, L2, R3, L4, R2, R2, R3, L2, L3, L5, R3, R1, L4, L3, R4, R2, R2, R2, R1, L4, R4, R1, R2, R1, L2, L2, R4, L1, L2, R3, L3, L5, L4, R4, L3, L1, L5, L3, L5, R5, L5, L4, L2, R1, L2, L4, L2, L4, L1, R4, R4, R5, R1, L4, R2, L4, L2, L4, R2, L4, L1, L2, R1, R4, R3, R2, R2, R5, L1, L2
        """.trimIndent()
    }
}