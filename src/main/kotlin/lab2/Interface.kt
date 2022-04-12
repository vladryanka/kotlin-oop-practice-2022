package lab2

interface ColorOfShape: Shape{
    val borderColor: Color
    val fillColor: Color
}
interface Shape
{
    fun square(): Float
}