import kotlin.math.max
import kotlin.math.min

fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }


fun solve1() {
    val (n, t, m) = nextInts()

    val mp = mutableMapOf<Int, Int>()

    for (i in 1..m) {
        val (a, b) = nextInts()
        val am = mp.getOrDefault(a, 0)
        val bm = mp.getOrDefault(b, 0)
        mp[a] = am + 1
        mp[b] = bm + 1
    }

}

fun main() {
//    val t = nextInt()
    val t = 1

    repeat(t) {
        solve()
    }
}


fun solve() {
    val events = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(2, 2, 2),
        intArrayOf(3, 3, 3),
        intArrayOf(4, 4, 4),
    )

    val k = 3

    val ans = maxValue(events, k)
    println(ans)
}

fun findNext(events: Array<IntArray>, target: Int): Int {
    var l = 0
    var r = events.size

    while (l < r) {
        val mid = (l + r) / 2
        if (events[mid][0] <= target) {
            l = mid + 1
        } else {
            r = mid
        }
    }

    return l
}

fun maxValue(events: Array<IntArray>, k: Int): Int {
    events.sortBy { it[0] }

    val n = events.size

    val dp = Array(k + 1) { IntArray(n + 1) { 0 } }

    for (i in n - 1 downTo 0) {
        for (j in 1..k) {
            val ni = findNext(events, events[i][1])
            dp[j][i] = max(
                dp[j][i + 1],
                events[i][2] + dp[j - 1][ni]
            )
        }
    }

    return dp[k][0]
}
