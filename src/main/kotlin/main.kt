import kotlin.math.max
import kotlin.math.min

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
    val req_skills = arrayOf("algorithms","math","java","reactjs","csharp","aws")

    val people = listOf(
        listOf("algorithms","math","java"),
        listOf("algorithms","math","reactjs"),
        listOf("java","csharp","aws"),
        listOf("reactjs","csharp"),
        listOf("csharp","math"),
        listOf("aws","java"),
    )

    val ans = smallestSufficientTeam(req_skills, people)
//    val ans = oneBits(4L)
    for (i in ans) {
        print("$i, ")
    }
}

fun oneBits(num: Long): Int {
    var n = num
    var cnt = 0
    while (n > 0) {
        if (n and 1 == 1L) cnt++
        n = n shr 1
    }
    return cnt
}

fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
    val m = req_skills.size
    val n = people.size

    val sMap = req_skills.mapIndexed {index: Int, s: String ->  s to index}.toMap()

    val pSkills = LongArray(n) {0L}

    for (i in people.indices) {
        for (j in people[i]) pSkills[i] = pSkills[i] or (1L shl sMap.getOrDefault(j, 0))
    }

    val dp = LongArray(1 shl m) {(1L shl n) - 1}

    dp[0] = 0

    for (i in 1L until (1L shl m)) {
        for (j in people.indices) {
            val remaining = i and pSkills[j].inv()
            if (i != remaining) {
                val hSkills = dp[remaining.toInt()] or (1L shl j)
                if (oneBits(hSkills) < oneBits(dp[i.toInt()])) {
                    dp[i.toInt()] = hSkills
                }
            }
        }
    }

    var ansMask = dp[dp.lastIndex]

    val ans = IntArray(oneBits(ansMask))

    var cnt = 0

    for (i in people.indices) {
        if ((ansMask and 1) == 1L) {
            ans[cnt++] = i
        }
        ansMask = ansMask shr 1
    }

    return ans
}