fun next() = readLine()!!.trim()

fun main() {
    var t = next().toInt()

    while(t-- > 0) {
        solve()
    }
}

fun solve() {
    val n = next().toCharArray()
    var ans = charArrayOf()
    var an = 0
    for (a in n) {
        if(ans.size == 3 && a !in ans) {
            ans = charArrayOf()
            an++
        }
        if (a !in ans) {
            ans += a
        }
    }
    an += if (ans.isEmpty()) 0 else 1
    println(an)
}
