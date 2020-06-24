import alonat.matrix.Matrix

fun main() {
    val matrixA = Matrix(
        arrayOf(
            arrayOf(1L, 2L, 4L),
            arrayOf(2L, 0L, 3L)
        )
    )
    val matrixB = Matrix(
        arrayOf(
            arrayOf(2L, 5L),
            arrayOf(1L, 3L),
            arrayOf(1L, 1L)
        )
    )
    val resultMult = matrixA * matrixB
    resultMult.print()

    val matrixC = Matrix(
        arrayOf(
            arrayOf(2L, 3L),
            arrayOf(4L, 5L)
        )
    )

    val result2 = binpow(matrixC, 2)
    val result3 = binpow(matrixC, 3)
    println("Matrix A^2")
    result2.print()
    println("Matrix A^3")
    result3.print()

    assert(binpow(2, 3) == 8L)
    assert(binpow(3, 4) == 81L)
    assert(binpow(8, 7) == 2097152L)
    assert(binpow(2, 32) == 4294967296)

    println("Fibonacci " + fibonacci(1_000_000))

    val v = 11
    val edgesList = arrayOf(
        Pair(0, 1),
        Pair(1, 5),
        Pair(2, 3),
        Pair(2, 4),
        Pair(2, 5),
        Pair(3, 7),
        Pair(3, 9),
        Pair(3, 10),
        Pair(5, 6),
        Pair(5, 8)
    )

    val adjMatr = createAdjMatrix(edgesList, v)

    val bfsPath = bfs(adjMatr)
    println("BFS path: $bfsPath")

    val dfsPath = dfs(adjMatr)
    println("DFS path: $dfsPath")
}
