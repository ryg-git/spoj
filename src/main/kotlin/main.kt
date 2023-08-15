import kotlin.math.ceil
import kotlin.math.max
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

    val grid = intArrayOf(4, 2, 0, 3, 2, 5)
//    val cost = intArrayOf(3, 4, 5, 1, 2)
//    val grid = intArrayOf(4, 4)

    val s = Solution()

    val ans = s.trap(grid)

    println(ans)
}

class Solution {
    fun trap(height: IntArray): Int {
        val mxht = height.withIndex().maxBy { it.value }?.index ?: 0

        return getWater(height, mxht)
    }

    private fun getWater(height: IntArray, r: Int): Int {

        var tw = 0
        var currentMax = 0

        for (i in 0 until r) {
            currentMax = max(currentMax, height[i])
            tw += currentMax - height[i]
        }

        currentMax = 0

        for (i in height.lastIndex downTo r + 1) {
            currentMax = max(currentMax, height[i])
            tw += currentMax - height[i]
        }

        return tw
    }
}
