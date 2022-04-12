package lab2

class Triangle(override val borderColor: Color, override val fillColor: Color, _side:Float, _height:Float ): ColorOfShape {
    private val side = _side
    private val height = _height

    override fun square(): Float
    {
        return (0.5 * side * height).toFloat()
    }
}