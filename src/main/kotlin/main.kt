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
    val str = next().toCharArray().dropWhile { it == '0' }.toMutableList()

    val half = str.size / 2

    var ne = true

    var ans = mutableListOf<Char>()

    var isSmaller = false
    var isLarger = false
    var isEqual = true

    for (i in half..str.lastIndex) {
        if (!isLarger && str[i] > str[str.lastIndex - i]) {
            isSmaller = true
            isEqual = false
        }
        if (!isSmaller && str[i] < str[str.lastIndex - i]) {
            isLarger = true
            isEqual = false
        }

        ne = ne && str[i] == str[str.lastIndex - i]

        str[i] = str[str.lastIndex - i]
    }

    if (isSmaller || isEqual) {
        var changed = false

        for (i in half..str.lastIndex) {
            if (str[i] != '9') {
                val newNum = (str[i].toInt() + 1).toChar()
                str[i] = newNum
                str[str.lastIndex - i] = newNum
                changed = true
                ans = str.toMutableList()
                break
            } else {
                str[i] = '0'
                str[str.lastIndex - i] = '0'
            }
        }

        if (!changed) {
            ans.add('1')
            for (i in 1..str.lastIndex) ans.add('0')
            ans.add('1')
        }
    } else {
        ans = str.toMutableList()
    }

    println(ans.joinToString(""))
}
