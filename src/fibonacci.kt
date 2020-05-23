import alonat.matrix.Matrix

fun fibonacci(n: Int): Long {
    val initial = Matrix(arrayOf(arrayOf(0L, 1L)))
    val complement = Matrix(
        arrayOf(
            arrayOf(0L, 1L),
            arrayOf(1L, 1L)
        )
    )

    val result = initial * binpow(complement, n - 1)

    return result.raw().first()[1]
}