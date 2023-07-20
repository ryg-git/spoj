fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }


fun solve1() {
    val (n, t, m) = nextInts()

    val mp = mutableMapOf<Int, Int>()

    for (i in 1..m) {
        val (a, b) = nextInts()
        val am = mp.getOrDefault(a, 0)
        val bm = mp.getOrDefault(b, 0)
        mp[a] = am + 1
        mp[b] = bm + 1
    }

}

fun main() {
//    val t = nextInt()
    val t = 1

    repeat(t) {
        solve()
    }
}

fun solve() {
    val a = intArrayOf(-2, 2, 1, -2)

    val ans = asteroidCollision(a)

    for (i in ans) print("$i, ")
    println()
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val st = ArrayDeque<Int>()
    val neg = mutableListOf<Int>()
    for (i in asteroids) {
        if (i > 0) {
            st.addLast(i)
        } else {
            if (st.isNotEmpty()) {
                var e = st.last()
                if (e + i > 0) {
                    continue
                } else if (e + i == 0) {
                    st.removeLast()
                } else if (e + i < 0) {
                    var equalFlag = false
                    while (e + i <= 0 && st.size > 0) {
                        st.removeLast()
                        if (e == (-1 * i)) {
                            equalFlag = true
                            break
                        }
                        if (st.isNotEmpty()) e = st.last()
                    }
                    if (!equalFlag && st.size == 0) neg.add(i)
                }
            } else {
                neg.add(i)
            }
        }
    }

    for (i in st) neg.add(i)

    return neg.toIntArray()
}



