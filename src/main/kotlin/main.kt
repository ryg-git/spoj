import kotlin.math.ceil


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
    val dist = intArrayOf(1,3,2)
    val ans = minSpeedOnTime(dist, 2.7)

    println(ans)
}

fun timeRequired(dist: IntArray, speed: Int): Double {
    var time = 0.0
    for (i in dist.indices) {
        val t = dist[i].toDouble() / speed.toDouble()
        time += if (i == dist.size - 1) t else ceil(t)
    }
    return time
}

fun bs(dist: IntArray, hour: Double): Int {
    var l = 0
    var r = 10000000
    var s = -1

    while (l < r) {
        val mid = (l + r) / 2

        if (timeRequired(dist, mid) <= hour) {
            r = mid - 1
            s = mid
        } else {
            l = mid + 1
        }
    }

    return s
}

fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
    if (dist.size > ceil(hour)) return -1

    return bs(dist, hour)
}
