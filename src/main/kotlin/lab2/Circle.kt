package lab2

import kotlin.math.PI

class Circle(override val borderColor: Color, override val fillColor: Color, val R: Float) : ColorOfShape {
    init {
        if (R <= 0) {
            throw IllegalArgumentException("Invalid value entered")
        }
    }

    override fun square(): Float {
        return (PI * R * R).toFloat()
    }

    override fun toString(): String {
        return "Circle(borderColor=$borderColor, fillColor=$fillColor, R=$R)"
    }

}