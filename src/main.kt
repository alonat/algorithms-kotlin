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
}
