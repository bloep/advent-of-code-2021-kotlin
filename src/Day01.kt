fun main() {
    fun part1(input: List<String>): Int {
        val nums = input.map(String::toInt);
        return nums.slice(0 until nums.size-1)
                .mapIndexed { i, num -> nums[i + 1] > num }
                .filter { x -> x }
                .size
    }

    fun part2(input: List<String>): Int {
        val nums = input.map(String::toInt);
        return nums.slice(0 until nums.size-3)
            .mapIndexed { i, num -> (num + nums[i+1] + nums[i+2]) < (nums[i+1] + nums[i+2] + nums[i+3]) }
            .filter { x -> x }
            .size
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
