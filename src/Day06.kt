import kotlin.system.measureNanoTime

fun main() {
    fun part1(input: List<String>): Int {
        return 0;
    }

    fun part2(input: List<String>, day: Int): Long {
        val fishes = input[0].split(",").map(String::toInt)
        val currFish = mutableListOf(0L,0L,0L,0L,0L,0L,0L,0L,0L)

        for (fish in fishes) {
            currFish[fish] += 1L
        }

        fun days(numDays: Int): Long {
            for (i in 0 until numDays) {
                val newFish = currFish[0];
                currFish.removeAt(0);
                currFish.add(newFish);
                currFish[6] = currFish[6] + newFish;
            }
            return currFish.sum();
        }

        return days(day);
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
//    check(part1(testInput) == 198)
    check(part2(testInput, 18) == 26L)
    check(part2(testInput, 256) == 26984457539L)

    val input = readInput("Day06")
//    println(part1(input))
    println(part2(input, 256))


    var v = 0L
    for (i in 1..10)
        v += measureNanoTime { part2(input,5000) } / 1000
    println(v / 10)
}
