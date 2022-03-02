package matrix

class Matrix(initialData: Array<DoubleArray>) {
    private val data: Array<DoubleArray>

    init {
        val n = initialData.size
        if (n == 0) error("Initial matrix data shouldn't be empty")

        val m = initialData[0].size
        if (m == 0) error("Initial matrix data shouldn't be empty")

        for (line in initialData) {
            if (line.size != m) error("Initial matrix data has wrong sizes")
        }

        data = Array(n) { i ->
            DoubleArray(m) { j ->
                initialData[i][j]
            }
        }
    }

    operator fun get(i: Int, j: Int): Double {
        checkIndexes(i, j)
        return data[i][j]
    }

    operator fun set(i: Int, j: Int, value: Double) {
        checkIndexes(i, j)
        data[i][j] = value
    }

    private fun checkIndexes(i: Int, j: Int) {
        if (i < 0 || i >= data.size || j < 0 || j >= data[0].size)
            throw IndexOutOfBoundsException("Indexes $i,$j out of matrix bounds ${data.size},${data[0].size}")
    }
}