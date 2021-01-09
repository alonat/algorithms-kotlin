fun <T> bubbleSort (arr: Array<T>, comp: (T, T) -> Int) {
    val n = arr.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - 1 - i) {
            if (comp(arr[j], arr[j + 1]) < 0) {
                arr[j] = arr[j + 1].also { arr[j + 1] = arr[j] }
            }
        }
    }
}

fun <T> sort (arr: Array<T>, comp: (T, T) -> Int) {
    fun qsort(arr: Array<T>, low: Int, high: Int) {
        if (low >= high) return
        val pivot = arr[(low..high).random()]
        var left = low
        var right = high

        while (left <= right) {
            while (comp(arr[left], pivot) < 0) left++
            while (comp(arr[right], pivot) > 0) right--

            if (left <= right) {
                arr[left] = arr[right].also { arr[right] = arr[left] }
                left++
                right--
            }
        }

        qsort(arr, low, left - 1)
        qsort(arr, left, high)
    }

    return qsort(arr, 0, arr.size - 1)
}

fun main () {
    val forBubbleSort = arrayOf(1, 4, 10, 2, 34, 12, 0)
    println("Bubble sort")
    println("${forBubbleSort.contentToString()} - unsorted array")
    bubbleSort(forBubbleSort) { a: Int, b: Int -> a - b }
    println("${forBubbleSort.contentToString()} - sorted array")

    val stringsForBSort = arrayOf("delta", "alpha", "charlie", "bravo")
    println("Bubble sort for strings")
    println("${stringsForBSort.contentToString()} - unsorted array")
    sort(stringsForBSort) { a: String, b: String -> a.compareTo(b) }
    println("${stringsForBSort.contentToString()} - sorted array")

    val forQuickSort = arrayOf(1, 4, 2, 10, 12, 34, 0)
    println("Quick sort")
    println("${forQuickSort.contentToString()} - unsorted array")
    sort(forQuickSort) { a: Int, b: Int -> a - b }
    println("${forQuickSort.contentToString()} - sorted array")

    val stringsForQSort = arrayOf("delta", "alpha", "charlie", "bravo")
    println("Quick sort for strings")
    println("${stringsForQSort.contentToString()} - unsorted array")
    sort(stringsForQSort) { a: String, b: String -> a.compareTo(b) }
    println("${stringsForQSort.contentToString()} - sorted array")
}
