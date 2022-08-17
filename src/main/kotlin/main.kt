fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = next().split(" ").map { it.toInt() }

fun main() {

    val t = nextInt()

    repeat (t) {
        readLine()
        val (_, k) = nextInts()
        val stations = nextInts().withIndex().groupBy { it.value }

        repeat(k) {
            val (s1, s2) = nextInts()

            stations[s1].let {
                if((it?.first()?.index ?: Int.MAX_VALUE) < (stations[s2]?.last()?.index ?: 0)) {
                    println("YES")
                } else {
                    println("NO")
                }
            }
        }
    }
}
