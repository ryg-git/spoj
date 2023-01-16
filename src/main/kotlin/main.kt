fun next() = readln().trim()
fun nextInt() = readln().trim().toInt()
fun nextInts() = readln().trim().split(" ").map { it.toInt() }

fun main() {
    val t = 1

    repeat(t) {
        solve()
    }
}

fun solve() {
    val (n, k) = nextInts()
    val arr = nextInts()

    var ans = 0;

    for (i in 0 until n)
        for (j in i + 1 until n)
            ans += if (i != j && (arr[i] + arr[j]) % k == 0) 1 else 0

    println(ans)
}
