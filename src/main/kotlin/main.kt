import java.util.*
import kotlin.math.ceil
import kotlin.math.max


fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }

fun isParan(s: String): Boolean {
    val ad = ArrayDeque<Char>()
    for (i in s) {
        if (i == '(') ad.add('(')
        else {
            if (ad.isNotEmpty()) ad.pop()
            else return false
        }
    }

    if (ad.isEmpty()) println(s)

    return ad.isEmpty()
}


fun solve1() {
    val s = next()
    val ind = mutableListOf<Int>()

    for (i in s.indices) {
        if (s[i] == '?') ind.add(i)
    }

    var an = 0

    println(ind.size)

    if (ind.isNotEmpty()) {
        val cn = 1 shl ind.size
        for (i in 0 until cn) {
            val itn = i.toString(2).padStart(ind.size, '0')
            var ns = s

            val av = ns.toCharArray()

            for (j in itn.indices) {
                if (itn[j] == '0') av[ind[j]] = '(' else av[ind[j]] = ')'
            }

            ns = String(av)

            if (isParan(ns)) an++
        }
    }

    println(an)
}

fun main() {
//    val t = nextInt()
    val t = 1

    repeat(t) {
        solve()
    }
}

fun calculateDP(i: Int, j: Int, dp: Map<Int?, Map<Int?, Double>>): Double {
    return (dp[max(0, i - 4)]!![j]!!
            + dp[max(0, i - 3)]!![j - 1]!!
            + dp[max(0, i - 2)]!![max(0, j - 2)]!!
            + dp[i - 1]!![max(0, j - 3)]!!) / 4
}

fun soupServings(n: Int): Double {
    val m = ceil(n / 25.0).toInt()
    val dp = mutableMapOf<Int?, MutableMap<Int?, Double>>()
    dp[0] = mutableMapOf()
    dp[0]!![0] = 0.5

    for (k in 1..m) {
        dp[k] = HashMap()
        dp[0]!![k] = 1.0
        dp[k]!![0] = 0.0
        for (j in 1..k) {
            dp[j]!![k] = calculateDP(j, k, dp)
            dp[k]!![j] = calculateDP(k, j, dp)
        }
        if (dp[k]!![k]!! > 1 - 1e-5) {
            return 1.0
        }
    }

    return dp[m]!![m]!!
}

fun solve() {
//    val dist = intArrayOf(1, 5, 233, 7)


    val ans = soupServings(100)

    println(ans)
}
