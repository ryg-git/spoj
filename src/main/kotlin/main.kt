import java.util.*


fun next() = readLine()!!.trim()
fun nextInt() = readLine()!!.trim().toInt()
fun nextInts() = readLine()!!.trim().split(" ").map { it.toInt() }


fun solve1() {
}

fun main() {
//    val t = nextInt()
    val t = 1

    repeat(t) {
        solve()
    }
}

fun solve() {
//    val nums = intArrayOf(1, 2, 4, 3, 5, 4, 7, 2)
    val nums = intArrayOf(0,2,1,0)
    val ans = peakIndexInMountainArray(nums)

    println(ans)
}

fun bs(arr: IntArray): Int {
    var l = 0
    var r = arr.lastIndex

    while (l < r) {
        val mid = (l + r) / 2
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            l = mid
            break
        }
        else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            l = mid + 1
        }
        else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            r = mid
        }
    }

    return l
}

fun peakIndexInMountainArray(arr: IntArray): Int {
    return bs(arr)
}
