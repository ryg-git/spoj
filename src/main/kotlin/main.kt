import kotlin.math.ceil
import kotlin.math.min


fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }

fun solve1() {

}

fun main() {
//    val t = nextInt()
    val t = 1

    repeat(t) {
        solve()
    }
}

fun solve() {
//    val nums = intArrayOf(1, 2, 4, 3, 5, 4, 7, 2)
//    val dist = intArrayOf(1, 1, 2)

    val grid = intArrayOf(993335, 993336, 993337, 993338, 993339, 993340, 993341)
//    val grid = intArrayOf(4, 4)


    val s = Solution()

    val ans = s.validPartition(grid)

    println(ans)
}

class Solution {
    fun validPartition(nums: IntArray): Boolean {
        val dp = BooleanArray(nums.size + 1) { false }
        dp[0] = true

        for (i in 2..nums.size) {
            val x = nums[i - 1]
            val y = nums[i - 2]

            if (x == y) dp[i] = dp[i] || dp[i - 2]

            if (i > 2) {
                val z = nums[i - 3]
                if (x == y && y == z) dp[i] = dp[i] || dp[i - 3]
                else if (x == y + 1 && y == z + 1) dp[i] = dp[i] || dp[i - 3]
            }
        }

        return dp.last()
    }
}
