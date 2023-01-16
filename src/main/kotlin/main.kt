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
    val (sc, vmc, st) = next().split(";")
    if (sc == "S") {
        val sp = st
            .split(Regex("(?=[A-Z])")).joinToString(" ") {
                val a = it.lowercase()
                a.filter { it1 -> it1 != '(' && it1 != ')' }
            }
        println(sp)
    } else if (sc == "C") {
        if (vmc in arrayOf("V", "M")) {
            val a = st.split(" ")
            val (fi, rest) = a.take(1) to a.drop(1)
            val ans = fi[0] + rest.joinToString("") {
                it.replaceFirstChar { it1 -> if (it1.isLowerCase()) it1.titlecase() else it1.toString() }
            }
            println(ans + if (vmc == "M") "()" else "")
        } else {
            val ans = st.split(" ").joinToString("") {
                it.replaceFirstChar { it1 -> if (it1.isLowerCase()) it1.titlecase() else it1.toString() }
            }
            println(ans)
        }
    }
}


