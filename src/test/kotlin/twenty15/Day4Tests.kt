package twenty15

import kotlin.test.*

class Day4Tests {

    @Test
    fun `use this test for fast feedback - looking for one zero`() {
        assertEquals(15, Day4().partThree(realInput()))
    }

    @Test
    fun `part 1 - real input`() {
        assertEquals(282749, Day4().partOne(realInput()))
    }

    @Test
    fun `part 2 - real input`() {
        assertEquals(9962624, Day4().partTwo(realInput()))
    }



    private fun realInput(): String {
        return "yzbqklnj"
    }
}

