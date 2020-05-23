package alonat.matrix

const val mod = 1000_000L

data class Matrix (val matrix: Array<Array<Long>>) {
    private fun countN() = matrix.count()
    private fun countM() = matrix.first().count()

    fun raw() = matrix

    fun print () {
        val row = this.countN()

        for (i in 0 until row) {
            println(matrix[i].contentToString())
        }
    }

    operator fun times(secondMatrix: Matrix): Matrix {
        val row1 = this.countN()
        val col1 = this.countM()
        val col2 = secondMatrix.countM()

        assert(row1 == col2)

        var resultArray = arrayOf<Array<Long>>()

        for (i in 0 until row1) {
            var lineArr = arrayOf<Long>()
            for (j in 0 until col2) {
                var item = 0L
                for (k in 0 until col1) {
                    item += (matrix[i][k] % mod * secondMatrix.raw()[k][j] % mod) % mod
                }
                lineArr += item
            }
            resultArray += lineArr
        }

        return Matrix(resultArray)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Matrix

        if (!matrix.contentDeepEquals(other.matrix)) return false

        return true
    }

    override fun hashCode(): Int {
        return matrix.contentDeepHashCode()
    }
}
