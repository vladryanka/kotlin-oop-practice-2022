package lab2

class Rectangle(override val borderColor: Color, override val fillColor: Color, val sideFirst: Float, val sideSecond: Float) :
    ColorOfShape {
    init {
        if (sideFirst <= 0 || sideSecond<=0) {
            throw IllegalArgumentException("Invalid value entered")
        }
    }
    override fun square(): Float {
        return sideFirst * sideSecond
    }

    override fun toString(): String {
        return "Rectangle(borderColor=$borderColor, fillColor=$fillColor, sideFirst=$sideFirst, sideSecond=$sideSecond)"
    }
}