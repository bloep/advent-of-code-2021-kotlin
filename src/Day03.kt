fun main() {
    fun part1(input: List<String>): Int {
        val linesAsBit = input.map {x -> x.toCharArray().map { it.toString().toInt() }}
        val bits = linesAsBit[0].size;

        fun commonBit(bitPos: Int): List<Int> {
            val oneBits = linesAsBit.map {x -> x[bitPos]}.fold(0) { p, v -> p + v };
            if (linesAsBit.size-oneBits < oneBits)
                return listOf(1, 0)
            return listOf(0, 1);
        }

        var gamma = 0b0;
        var epsilon = 0b0;
        for (x in bits-1 downTo 0) {
            val (g, e) = commonBit(x)

            gamma = gamma or (g shl (bits-x-1))
            epsilon = epsilon or (e shl (bits-x-1))
        }

        return gamma * epsilon;
    }

    fun part2(input: List<String>): Int {
        val linesAsBit = input.map {x -> x.toCharArray().map { it.toString().toInt() }}
        val bits = linesAsBit[0].size;

        fun commonBit(subset: List<List<Int>>, bitPos: Int): List<Int> {
            val oneBits = subset.map {x -> x[bitPos]}.fold(0) { p, v -> p + v };
            if(subset.size-oneBits <= oneBits)
                return listOf(1, 0)
            return listOf(0, 1);
        }

        var o2 = linesAsBit.toList();
        var co2 = linesAsBit.toList();

        for (x in 0..bits) {
            if (co2.size > 1) {
                val (m, l) = commonBit(co2, x);
                co2 = co2.filter {y -> y[x] == m}
            }
            if (o2.size > 1) {
                val (m, l) = commonBit(o2, x);
                o2 = o2.filter {y -> y[x] == l}
            }
        }

        return o2[0].joinToString("") { it.toString() }.toInt(2) * co2[0].joinToString("") { it.toString() }.toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
