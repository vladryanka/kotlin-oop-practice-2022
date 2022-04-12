package lab2

class Foursquare(override val borderColor: Color, override val fillColor: Color,_side:Float): ColorOfShape
{
    private val side = _side
    override fun square(): Float
    {
        return side*side
    }


}