import java.util.*
import kotlin.collections.ArrayList

fun createAdjMatrix (edges: Array<Pair<Int, Int>>, v: Int): Array<IntArray> {
    var adjMatr = arrayOf<IntArray>()
    for (i in 0 until v) {
        adjMatr += IntArray(v) { 0 }
    }

    edges.forEach { el ->
        run {
            val (i, j) = el
            adjMatr[i][j] = 1
            adjMatr[j][i] = 1
        }
    }

    return adjMatr
}

fun bfs(matrix: Array<IntArray>): ArrayList<Int> {
    val queue = LinkedList<Int>()
    val path = ArrayList<Int>()
    val visited = BooleanArray(matrix.size) { false }
    queue.push(0)

    while(queue.isNotEmpty()) {
        val current = queue.removeLast()
        if (visited[current]) continue

        visited[current] = true
        matrix[current].forEachIndexed { i, el -> if (el != 0) queue.push(i) }
        path.add(current)
    }

    return path
}

fun dfs(matrix: Array<IntArray>): ArrayList<Int> {
    val queue = LinkedList<Int>()
    val path = ArrayList<Int>()
    val visited = BooleanArray(matrix.size) { false }
    queue.push(0)

    while(queue.isNotEmpty()) {
        val current = queue.pop()
        if (visited[current]) continue

        visited[current] = true
        matrix[current].forEachIndexed { i, el -> if (el != 0) queue.addFirst(i) }
        path.add(current)
    }

    return path
}
