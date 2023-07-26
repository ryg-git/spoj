import java.util.*
import kotlin.collections.ArrayDeque


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
        solve1()
    }
}

fun solve() {
//    val nums = intArrayOf(1, 2, 4, 3, 5, 4, 7, 2)
//    val nums = intArrayOf(0,2,1,0)
//    val ans = peakIndexInMountainArray(nums)
//
//    println(ans)
}

