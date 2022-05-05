package lab2

class Triangle(override val borderColor: Color, override val fillColor: Color, val side: Float, val height: Float) :
    ColorOfShape {
    init {
        if (side <= 0 || height <= 0) {
            throw IllegalArgumentException("Invalid value entered")
        }
    }

    override fun square(): Float {
        return (0.5 * side * height).toFloat()
    }

    override fun toString(): String {
        return "Triangle(borderColor=$borderColor, fillColor=$fillColor, side=$side, height=$height)"
    }
}