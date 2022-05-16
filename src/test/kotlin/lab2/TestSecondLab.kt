package lab2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TestSecondLab {

    private val testShapeCollector = ShapeCollector()
    private val color1 = Color(255, 255, 255, 20)
    private val color2 = Color(0, 0, 0, 80)
    private val triangle1 = Triangle(color2, color1, 2.0f, 2.0f)
    private val triangle2 = Triangle(color1, color2, 7.0f, 2.0f)

    @Test
    fun addFigure() {
        val circle = Circle(color1, color2, 5.0f)
        testShapeCollector.addFigure(circle)
        assertEquals(
            listOf(circle), testShapeCollector.returnList()
        )
    }

    @Test
    fun minSquare() {
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(
            2.0f, testShapeCollector.minSquare()
        )
    }

    @Test
    fun maxSquare() {
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(
            7.0f, testShapeCollector.maxSquare()
        )
    }

    @Test
    fun sum() {
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(
            9.0f, testShapeCollector.sum()
        )

    }

    @Test
    fun findBorderColor() {
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(listOf(triangle2)[0], testShapeCollector.findBorderColor(color1)[0])
    }

    @Test
    fun findFillColor() {
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(listOf(triangle1)[0], testShapeCollector.findFillColor(color1)[0])
    }

    @Test
    fun returnList() {
        val circle = Circle(color1, color2, 5.0f)
        testShapeCollector.addFigure(circle)
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(testShapeCollector.returnList(), listOf(circle, triangle1,triangle2))
    }

    @Test
    fun fillColorMap() {
        testShapeCollector.fillColorMap().forEach {
            assertEquals(it.key, it.value[0].fillColor)
        }
    }

    @Test
    fun borderColorMap() {
        testShapeCollector.borderColorMap().forEach {
            assertEquals(it.key, it.value[0].borderColor)
        }
    }

    @Test
    fun returnType() {
        val circle = Circle(color1, color2, 5.0f)
        testShapeCollector.addFigure(circle)
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals( listOf(circle), testShapeCollector.returnType(Circle::class.java))
    }
}