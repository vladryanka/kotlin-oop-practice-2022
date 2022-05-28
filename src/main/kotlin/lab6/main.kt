package lab6
import lab2.*
import lab2.ShapeCollector


fun main() {
    val color1 = Color(255, 255, 255, 20)
    val color2 = Color(0, 0, 0, 80)
    val circle = Circle(color1, color2, 10.0f)
    val triangle = Triangle(color2, color1, 7.0f, 2.0f)
    val rectangle = Rectangle(color1, color1, 4.0f, 6.0f)
    val foursquare = Foursquare(color2, color2, 5.0f)
    val testShapeCollector = ShapeCollector()
    testShapeCollector.addFigure(circle)
    testShapeCollector.addFigure(triangle)
    testShapeCollector.addFigure(rectangle)
    testShapeCollector.addFigure(foursquare)
    val test = Serialization()
    test.writeToFile("File.txt", testShapeCollector.returnList())
    val list = test.readFromFile("File.txt")
    var i = 0

    while (i != list.size - 1)
    {
        testShapeCollector.addFigure(list[i])
        i++
    }
    test.writeToFile("File2.txt", testShapeCollector.returnList())
}