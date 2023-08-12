import kotlin.math.max

fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }


fun solve1() {
//    val (n, m) = nextInts()
}

fun main() {
//    val t = nextInt()
    val t = 1

    repeat(t) {
        solve()
    }
}

fun solve() {
//    val dist = intArrayOf(1, 2, 3, 4)

    val s = Solution()

    val nums = intArrayOf(7, 1, 5, 3, 6, 4)


    val ans = s.maxProfit(nums)

    println(ans)
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var b = 0
        var s = 1
        var pro = 0

        while (s < prices.size) {
            if (prices[b] > prices[s]) {
                s = 1 + ++b
            } else {
                pro = max(pro, prices[s] - prices[b])
                s++
            }
        }

        return pro
    }
}