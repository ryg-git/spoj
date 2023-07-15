import kotlin.math.max

fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }

fun main() {
    val t = nextInt()

    repeat(t) {
        solve()
    }
}

fun solve() {
    val locations = intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1)
    val diff = -2

    val ans = longestSubsequence(locations, diff)
    println(ans)
}

fun longestSubsequence(arr: IntArray, difference: Int): Int {
    val m = HashMap<Int, Int>()
    var ans = 0

    for (i in arr) {
        val ad = m.getOrDefault(i - difference, 0)
        m[i] = ad + 1
        ans = max(ans, m.getOrDefault(i, 0))
    }
    return ans
}
