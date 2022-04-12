package lab2

class Rectangle(override val borderColor: Color, override val fillColor: Color, _sideFirst: Float, _sideSecond: Float):
    ColorOfShape {
    private val sideFirst = _sideFirst
    private val sideSecond = _sideSecond
    override fun square(): Float
    {
        return sideFirst*sideSecond
    }
}