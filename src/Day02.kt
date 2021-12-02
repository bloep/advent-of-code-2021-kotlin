fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map {v -> v.split(" ")}
            .fold(mutableMapOf("depth" to 0, "hor" to 0)) { acc, (cmd, value) ->
                val valueInt = value.toInt()
                when (cmd) {
                    "up" -> acc["depth"] = acc["depth"]!! - valueInt
                    "down" -> acc["depth"] = acc["depth"]!! + valueInt
                    "forward" -> acc["hor"] = acc["hor"]!! + valueInt
                }
                acc
            }
            .run { this["depth"]!! * this["hor"]!! }
    }

    fun part2(input: List<String>): Int {
        return input
            .map {v -> v.split(" ")}
            .fold(mutableMapOf("aim" to 0, "hor" to 0, "depth" to 0)) { acc, (cmd, value) ->
                val valueInt = value.toInt()
                when (cmd) {
                    "up" -> acc["aim"] = acc["aim"]!! - valueInt
                    "down" -> acc["aim"] = acc["aim"]!! + valueInt
                    "forward" -> {
                        acc["hor"] = acc["hor"]!! + valueInt
                        acc["depth"] = acc["depth"]!! + acc["aim"]!! * valueInt
                    }
                }
                acc
            }
            .run { this["depth"]!! * this["hor"]!! }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
