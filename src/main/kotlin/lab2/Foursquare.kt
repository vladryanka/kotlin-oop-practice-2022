package lab2

class Foursquare(override val borderColor: Color, override val fillColor: Color, val side: Float) : ColorOfShape {
    init {
        if (side <= 0) {
            throw IllegalArgumentException("Invalid value entered")
        }
    }
    override fun square(): Float {
        return side * side
    }

    override fun toString(): String {
        return "Foursquare(borderColor=$borderColor, fillColor=$fillColor, side=$side)"
    }
}