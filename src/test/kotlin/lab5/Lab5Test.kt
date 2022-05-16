package lab5

import lab2.Color
import lab2.ColorOfShape
import lab2.Triangle
import org.junit.jupiter.api.Test


import org.junit.jupiter.api.Assertions.*

internal class Lab5Test {

    private val testShapeCollector = GenericShapeCollector<ColorOfShape>()
    private val color1 = Color(255, 255, 255, 20)
    private val color2 = Color(0, 0, 0, 80)
    private val triangle1 = Triangle(color2, color1, 2.0f, 2.0f)
    private val triangle2 = Triangle(color1, color2, 7.0f, 2.0f)

    @Test
    fun getSorted() {
        val list = mutableListOf<ColorOfShape>()
        assertEquals(testShapeCollector.getSorted(Comparator()), list)
        list.add(triangle1)
        list.add(triangle2)
        testShapeCollector.addFigure(triangle1)
        testShapeCollector.addFigure(triangle2)
        assertEquals(testShapeCollector.getSorted(Comparator()),list)
    }

    @Test
    fun addAll() {
        val list = mutableListOf<ColorOfShape>()
        testShapeCollector.addAll(list)
        assertEquals(testShapeCollector.returnList(), list)
        list.add(triangle1)
        list.add(triangle2)
        testShapeCollector.addAll(list)
        assertEquals(testShapeCollector.returnList(),list)
    }
}