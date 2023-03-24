import kotlin.math.sqrt

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
    val (n, m) = nextInts()

    for (i in (if(n > 1) n else 2)..m) {
        var p = true
        val up = sqrt(i.toDouble()).toInt()
        for (j in 2..up) {
            if (i % j == 0) {
                p = false
                break
            }
        }
        if (p) println(i)
    }
}
