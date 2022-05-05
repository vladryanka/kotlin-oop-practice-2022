package lab2

data class Color(val red: Int, val green: Int, val blue: Int, val clarity: Int) {
    init {
        if (red < 0 || red > 255)
            throw error("red is incorrect")
        if (green < 0 || green > 255)
            throw error("green is incorrect")
        if (blue < 0 || blue > 255)
            throw error("blue is incorrect")
        if (clarity < 0 || clarity > 101)
            throw error("clarity is incorrect")
    }

    override fun toString(): String {
        return "Color(red=$red, green=$green, blue=$blue, clarity=$clarity)"
    }

}