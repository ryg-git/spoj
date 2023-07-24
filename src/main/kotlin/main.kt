import java.util.*


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
//    val nums = intArrayOf(1, 3, 5, 4, 7)
    val ans = myPow(3.0, 3)

    println(ans)
}

fun lxPow(x: Double, n: Long): Double {
    if (n == 0L) return 1.0
    if (n == 1L) return x
    if (n < 0) return 1.0 / lxPow(x, -1L * n)
    return if (n % 2 == 0L) lxPow(x * x, n / 2) else x * lxPow(x * x, (n - 1) / 2)
}

fun myPow(x: Double, n: Int): Double {
    return lxPow(x, n.toLong())
}
