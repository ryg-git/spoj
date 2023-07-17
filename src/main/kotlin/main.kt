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

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun solve() {
    val l1 = ListNode(9).apply { next = ListNode(4) }
    val l2 = ListNode(9)

    val ans = addTwoNumbers(l1, l2)
    println(ans)
}

fun lastNodes(ans: MutableList<Int>, l1: ListNode?, l2: ListNode?) {
    if (l1!!.next != null) {
        if (l2!!.next == null) {
            return
        }
    }
}

fun getNumInString(num: ListNode?): String {
    return if (num == null) ""
    else num.`val`.toString() + getNumInString(num.next)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var sl1 = getNumInString(l1)
    var sl2 = getNumInString(l2)

    if (sl1.length > sl2.length) sl2 = sl2.padStart(sl1.length, '0')
    else sl1 = sl1.padStart(sl2.length, '0')

//    println(sl1)
//    println(sl2)

    var carry = 0

    var an = ""

    for (i in sl1.lastIndex downTo 0) {
        val s = carry + sl1[i].digitToIntOrNull()!! + sl2[i].digitToIntOrNull()!!

        val re = s % 10
        carry = s / 10

        an += re
    }

    if(carry > 0) an += carry

//    println(an.reversed())

    var fir: ListNode? = null

    for (i in an) {
        fir = ListNode(i.digitToInt()).apply { next = fir }
    }

//    while (fir != null) {
//        print(fir.`val`)
//        fir = fir.next
//    }

    return fir
}
