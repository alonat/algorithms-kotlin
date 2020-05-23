import alonat.matrix.Matrix

fun binpow(a: Long, n: Int): Long {
    if (n == 1) return a
    val result = binpow(a, n shr 1)
    if (n and 1 == 0) return result * result

    return a * binpow(a, n - 1)
}

fun binpow(a: Matrix, n: Int): Matrix {
    if (n == 1) return a
    val result = binpow(a, n shr 1)
    if (n and 1 == 0) return result * result

    return a * binpow(a, n - 1)
}