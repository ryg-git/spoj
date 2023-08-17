import kotlin.math.max
import kotlin.math.min

class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val dp = Array(mat.size) { IntArray(mat[0].size) { 1000_000 } }

        val adj1 = arrayOf(
            -1 to 0,
            0 to -1
        )

        for (i in mat.indices) {
            for (j in mat[i].indices) {
                if (mat[i][j] == 0) dp[i][j] = 0
                else {
                    for ((x, y) in adj1) {
                        val a = i + x
                        val b = j + y
                        if (a in mat.indices && b in mat[i].indices) {
                            dp[i][j] = min(dp[a][b] + 1, dp[i][j])
                        }
                    }
                }
            }
        }

        val adj2 = arrayOf(
            1 to 0,
            0 to 1
        )

        for (i in mat.indices.reversed()) {
            for (j in mat[i].indices.reversed()) {
                if (mat[i][j] == 0) dp[i][j] = 0
                else {
                    for ((x, y) in adj2) {
                        val a = i + x
                        val b = j + y

                        if (a in mat.indices && b in mat[i].indices) {
                            dp[i][j] = min(dp[a][b] + 1, dp[i][j])
                        }
                    }
                }

            }
        }

        return dp
    }
}

fun solve() {

    val mat = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 1, 0),
    )

    val s = Solution()

    val ans = s.updateMatrix(mat)

    for (i in ans) println(i.contentToString())
}


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

