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

    val grid = intArrayOf(3, 2, 1, 5, 6, 4)
//    val grid = intArrayOf(4, 4)

    val s = Solution()

    val ans = s.findKthLargest(grid, 2)

    println(ans)
}

class Solution {
    private fun partition(x: Int, nums: IntArray, l: Int, r: Int): IntArray {
        val piv = nums[l]

        var part = l + 1

        for (i in l + 1..r) {
            if (nums[i] >= piv) {
                nums[part] = nums[i].also { nums[i] = nums[part] }
                part++
            }
        }

        part--

        nums[l] = nums[part].also { nums[part] = nums[l] }

        if (part == x) return nums
        else if (x in part + 1..r) return partition(x, nums, part + 1, r)
        else if (x in l until part) return partition(x, nums, l, part - 1)
        return nums
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        val arr = partition(k - 1, nums, 0, nums.lastIndex)
        return arr[k - 1]
    }
}
