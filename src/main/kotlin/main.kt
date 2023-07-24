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
    val ans = allPossibleFBT(3)

    println(ans)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun allPossibleFBT(n: Int): List<TreeNode?> {
    if (n % 2 == 0) {
        return listOf()
    }

    val dp = Array(n + 1) { mutableListOf<TreeNode?>() }

    dp[1] = mutableListOf(TreeNode(0))

    for (cnt in 3..n step 2) {
        for (i in 1 until cnt step 2) {
            val j = cnt - i - 1
            for (left in dp[i]) {
                for (right in dp[j]) {
                    val tn = TreeNode(0)
                    tn.left = left
                    tn.right = right
                    dp[cnt].add(tn)
                }
            }
        }
    }

    return dp[n]
}
