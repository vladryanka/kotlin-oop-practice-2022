package lab2

import kotlin.math.PI

class Circle(override val borderColor: Color, override val fillColor: Color, _R:Float): ColorOfShape {
    private val R = _R
    override fun square(): Float {
        return (PI * R * R).toFloat()
    }
}