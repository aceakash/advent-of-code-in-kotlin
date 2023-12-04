package helpers


/**
 * Extract a list of integers from a space-separated string.
 *
 * e.g. " 1    2    3 " -> listOf(1, 2, 3)
 */
fun parseIntList(str: String): List<Int> {
    return str.trim().split("""\s+""".toRegex()).map {
        it.trim().toInt()
    }
}
