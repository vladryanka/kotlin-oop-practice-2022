package lab2

class ShapeCollector {
    private val listOfShapes = mutableListOf<ColorOfShape>()

    fun addFigure(figure: ColorOfShape) {
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

    fun findBorderColor(color: Color): List<ColorOfShape> {
        val listFigures: ArrayList<ColorOfShape> = arrayListOf()
        for (i in 0 until listOfShapes.size) if (listOfShapes[i].borderColor == color) {
            listFigures.add(listOfShapes[i])
        }
        return listFigures
    }

    fun findFillColor(color: Color): List<ColorOfShape> {
        val listFigures: ArrayList<ColorOfShape> = arrayListOf()
        for (i in 0 until listOfShapes.size) if (listOfShapes[i].fillColor == color) listFigures.add(listOfShapes[i])
        return listFigures
    }

    fun returnList(): List<ColorOfShape> {

        return listOfShapes
    }

    fun counter(): Int {
        return listOfShapes.size
    }

    fun fillColorMap(): Map<Color, List<ColorOfShape>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    fun borderColorMap(): Map<Color, List<ColorOfShape>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    fun returnType(nameOfFigure: String): List<ColorOfShape> {
        return listOfShapes.filter{it::class.simpleName == nameOfFigure }
    }
    override fun toString(): String {
        var print = ""
        listOfShapes.forEach { print += it.toString() + "\n" }
        return print
    }
}