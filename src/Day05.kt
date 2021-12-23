import kotlin.system.measureNanoTime

fun main() {
    fun part1(input: List<String>): Int {
        return 0;
    }

    fun part2(input: List<String>): Int {
        val r = Regex("(?<x1>\\d+),(?<y1>\\d+) -> (?<x2>\\d+),(?<y2>\\d+)");
        val coords = input.map {x -> r.find(x)!!.groups}

        val map = mutableMapOf<String,Int>();

        for (coord in coords) {
            var x1 = coord["x1"]!!.value.toInt();
            val x2 = coord["x2"]!!.value.toInt();
            var y1 = coord["y1"]!!.value.toInt();
            val y2 = coord["y2"]!!.value.toInt();

            val pos = "$y1-$x1"
            if (!map.containsKey(pos)) {
                map[pos] = 0
            }
            map[pos] = map[pos]!! + 1

            while (x1 != x2 || y1 != y2) {
                if (x1 > x2) {
                    x1--;
                } else if (x1 < x2){
                    x1++;
                }

                if (y1 > y2) {
                    y1--;
                } else if (y1 < y2) {
                    y1++;
                }
                val pos = "$y1-$x1"
                if (!map.containsKey(pos)) {
                    map[pos] = 0
                }
                map[pos] = map[pos]!! + 1
            }
        }

        return map.values.count { x -> x > 1 };
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
//    check(part1(testInput) == 198)
//    check(part2(testInput) == 12)

    val input = readInput("Day05")
//    println(part1(input))
    println(part2(input))


    var v = 0L
    for (i in 1..10)
        v += measureNanoTime { part2(input) } / 1000
    println(v / 10)

}
