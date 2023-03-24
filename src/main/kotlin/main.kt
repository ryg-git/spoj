import java.util.*


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
    val expr = next()
    val st = ArrayDeque<Char>(listOf())
    for (i in expr.toCharArray()) {
        if (i == ')')  {
            val tp = st.removeLast()
            st.removeLast()
            print(tp)
        }
        else if (i.isLetter()) print(i)
        else st.addLast(i)
    }
    println()
}
