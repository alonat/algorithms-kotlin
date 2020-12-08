import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val amount = scanner.nextLine().toInt()
    val numbers = scanner.nextLine().split(" ").toMutableList()

    var sum = 0
    for (i in 1..numbers.size - 1) {
        sum += numbers[i].toInt()
    }
}
