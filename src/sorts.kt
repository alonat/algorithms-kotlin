fun bubbleSort (arr: Array<Int>) {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j + 1].also { arr[j + 1] = arr[j] }
            }
        }
    }
}

fun getPartition (arr: Array<Int>, low: Int, high: Int): Int {
    val pivot = arr[(low + high) / 2]
    var left = low
    var right = high
    while (left <= right) {
        while (arr[left] < pivot) left++

        while (arr[right] > pivot) right--

        if (left <= right) {
            arr[right] = arr[left].also { arr[left] = arr[right] }

            left++
            right--
        }
    }
    return left
}

fun qsort (arr: Array<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = getPartition(arr, low, high)

        qsort(arr, low, pi - 1)
        qsort(arr, pi, high)
    }
}

fun main () {
    val forBubbleSort = arrayOf(1, 4, 10, 2, 34, 12, 0)
    println("Bubble sort")
    println("${forBubbleSort.contentToString()} - unsorted array")
    bubbleSort(forBubbleSort)
    println("${forBubbleSort.contentToString()} - sorted array")

    val forQuickSort = arrayOf(1, 4, 2, 10, 12, 34, 0)
    println("Quick sort")
    println("${forQuickSort.contentToString()} - unsorted array")
    qsort(forQuickSort, 0, forQuickSort.size - 1)
    println("${forQuickSort.contentToString()} - sorted array")
}
