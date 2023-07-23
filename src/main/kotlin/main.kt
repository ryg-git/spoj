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
    val ans = knightProbability(3, 2, 0, 0)

    println(ans)
}

fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
    val directions = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, -2),
        intArrayOf(-1, 2),
        intArrayOf(-1, -2),
        intArrayOf(2, 1),
        intArrayOf(2, -1),
        intArrayOf(-2, 1),
        intArrayOf(-2, -1)
    )

    val dp = Array(k + 1) {
        Array(n) {
            DoubleArray(
                n
            )
        }
    }

    dp[0][row][column] = 1.0

    for (moves in 1..k) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (direction in directions) {
                    val prevI = i - direction[0]
                    val prevJ = j - direction[1]
                    // Check if the previous cell is within the chessboard
                    if (prevI in 0 until n && prevJ >= 0 && prevJ < n) {
                        // Add the previous probability divided by 8
                        dp[moves][i][j] += dp[moves - 1][prevI][prevJ] / 8.0
                    }
                }
            }
        }
    }

    var totalProbability = 0.0
    for (i in 0 until n) {
        for (j in 0 until n) {
            totalProbability += dp[k][i][j]
        }
    }

    return totalProbability
}
