package lab5

import lab2.ColorOfShape
import lab2.Rectangle
import lab2.Circle
import lab2.Foursquare
import lab2.Triangle
import lab2.Color

fun main()
{
    val color1 = Color(255, 255, 255, 20)
    val color2 = Color(0, 0, 0, 80)
    val circle = Circle(color1, color2, 10.0f)
    println(circle.square())
    val triangle = Triangle(color2, color1, 7.0f, 2.0f)
    println(triangle.square())
    val rectangle = Rectangle(color1, color1, 4.0f, 6.0f)
    println(rectangle.square())
    val foursquare = Foursquare(color2, color2, 5.0f)
    println(foursquare.square())
    val circle2 = Circle(color2, color2, 12.0f)
    val triangle2 = Triangle(color1, color1, 4.0f, 8.0f)
    val testShapeCollector = GenericShapeCollector<ColorOfShape>()
    testShapeCollector.addFigure(circle)
    testShapeCollector.addFigure(triangle)
    testShapeCollector.addFigure(rectangle)
    testShapeCollector.addFigure(foursquare)
    testShapeCollector.addFigure(circle2)
    testShapeCollector.addFigure(triangle2)
    println("ShapeCollection = ${testShapeCollector.returnList()}")
    println("Size of ShapeCollection = ${testShapeCollector.counter()}")
    println("Sum of square = ${testShapeCollector.sum()}")
    println("Min square = ${testShapeCollector.minSquare()}")
    println("Max square = ${testShapeCollector.maxSquare()}")
    println("Search all shapes by border color = ${testShapeCollector.findBorderColor(color1)}")
    println("Search all shapes by fill color = ${testShapeCollector.findFillColor(color2)}")
    println("Shapes grouped by border color = ${testShapeCollector.borderColorMap()}")
    println("Shapes grouped by border color = ${testShapeCollector.fillColorMap()}")
    println("Shapes grouped by type = ${testShapeCollector.returnType(Circle::class.java)}")
    println("Shapes sorted by square:${testShapeCollector.getSorted(Comparator())}")

}