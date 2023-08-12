import kotlin.math.ceil
import kotlin.math.min


fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }

fun moveCount(xLoc: Int, yLoc: Int, grd: Array<CharArray>, vis: Array<BooleanArray>): Int {
    val dirs = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    vis[xLoc][yLoc] = true

    var cnt = 1

    for (i in vis) {
        for (j in i) print("$j, ")
        println()
    }

    println()

    cnt += if (((xLoc + dirs[0].first) in 1 until grd.lastIndex) && ((yLoc + dirs[0].second) in 1 until grd.first().lastIndex)) {
        val nx = xLoc + dirs[0].first
        val ny = yLoc + dirs[0].second
        if (grd[nx][ny] != '#' && !vis[nx][ny]) {
            moveCount(nx, ny, grd, vis)
        } else 0
    } else 0
    cnt += if (((xLoc + dirs[1].first) in 1 until grd.lastIndex) && ((yLoc + dirs[1].second) in 1 until grd.first().lastIndex)) {
        val nx = xLoc + dirs[1].first
        val ny = yLoc + dirs[1].second
        if (grd[nx][ny] != '#' && !vis[nx][ny]) {
            moveCount(nx, ny, grd, vis)
        } else 0
    } else 0
    cnt += if (((xLoc + dirs[2].first) in 1 until grd.lastIndex) && ((yLoc + dirs[2].second) in 1 until grd.first().lastIndex)) {
        val nx = xLoc + dirs[2].first
        val ny = yLoc + dirs[2].second
        if (grd[nx][ny] != '#' && !vis[nx][ny]) {
            moveCount(nx, ny, grd, vis)
        } else 0
    } else 0
    cnt += if (((xLoc + dirs[3].first) in 1 until grd.lastIndex) && ((yLoc + dirs[3].second) in 1 until grd.first().lastIndex)) {
        val nx = xLoc + dirs[3].first
        val ny = yLoc + dirs[3].second
        if (grd[nx][ny] != '#' && !vis[nx][ny]) {
            moveCount(nx, ny, grd, vis)
        } else 0
    } else 0
    return cnt
}

fun solve1() {
    val (n, m) = nextInts()
    val grd = Array(n) { next().toCharArray() }
    val vis = Array(n) { BooleanArray(m) { false } }
    val ans = moveCount(1, 1, grd, vis)
    println(ans)
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

    val ans = minimumDeleteSum("sea", "eat")

    println(ans)
}

fun minimumDeleteSum(s1: String, s2: String): Int {
    val dp = Array(s1.length + 1) { IntArray(s2.length + 1) }

    for (i in s1.indices) {
        dp[i + 1][0] = dp[i][0] + s1[i].toInt()
    }

    for (j in s1.indices) {
        dp[0][j + 1] = dp[0][j] + s2[j].toInt()
    }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) dp[i][j] = dp[i - 1][j - 1]
            else {
                dp[i][j] = min(
                    s1[i - 1].toInt() + dp[i - 1][j],
                    s2[j - 1].toInt() + dp[i][j - 1]
                )
            }
        }
    }

    return dp[s1.length][s2.length]
}
