package lab5

import lab2.Color
import lab2.ColorOfShape

class GenericShapeCollector<out T: ColorOfShape> {

    private val listOfShapes = mutableListOf<T>()

    fun addFigure(figure: @UnsafeVariance T) {
        listOfShapes.add(figure)
    }

    fun minSquare(): Float {
        return listOfShapes.minOf { it.square() }
    }

    fun maxSquare(): Float {
        return listOfShapes.maxOf { it.square() }
    }

    fun sum(): Float {
        var sumValue = 0.0f
        for (element in listOfShapes) {
            sumValue += element.square()
        }
        return sumValue
    }

    fun findBorderColor(color: Color): List<T> {
        val listFigures: ArrayList<T> = arrayListOf()
        for (i in 0 until listOfShapes.size) if (listOfShapes[i].borderColor == color) {
            listFigures.add(listOfShapes[i])
        }
        return listFigures
    }

    fun findFillColor(color: Color): List<T> {
        val listFigures: ArrayList<T> = arrayListOf()
        for (i in 0 until listOfShapes.size) if (listOfShapes[i].fillColor == color) listFigures.add(listOfShapes[i])
        return listFigures
    }

    fun returnList(): List<T> {
        return listOfShapes
    }

    fun counter(): Int {
        return listOfShapes.size
    }

    fun fillColorMap(): Map<Color, List<T>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    fun borderColorMap(): Map<Color, List<T>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    fun returnType(nameOfFigure: Class<out ColorOfShape>) = listOfShapes.filterIsInstance(nameOfFigure)

    fun getSorted(comparator: Comparator): List<T> {
        return listOfShapes.sortedWith(comparator)
    }
    fun addAll(list: List<@UnsafeVariance T>) {
        list.forEach { listOfShapes.add(it) }
    }

    override fun toString(): String {
        var print = ""
        listOfShapes.forEach { print += it.toString() + "\n" }
        return print
    }
}