fun next() = readLine()!!.trim()

fun main() {
    var inp = next().toInt()

    while(inp != 42) {
        println(inp)
        inp = next().toInt()
    }
}
