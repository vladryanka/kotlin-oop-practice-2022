package lab2

class ShapeCollector {
    private val listOfShapes = mutableListOf<ColorOfShape>()

    fun addFigure(figure: ColorOfShape)
    {
        listOfShapes.add(figure)
    }
    fun minSquare(): Float
    {
        val minSquareValue = listOfShapes.minOf { it.square() }
        return minSquareValue
    }
    fun maxSquare():Float
    {
        val maxSquareValue: Float = listOfShapes.maxOf { it.square() }
        return maxSquareValue
    }
    fun sum(): Float{
        var sumValue = 0.0f
        for (element in listOfShapes)
        {
            sumValue += element.square()
        }
        return sumValue
    }
    fun findBorderColor(color:Color): List<ColorOfShape>
    {

        val listFigures: ArrayList<ColorOfShape> = arrayListOf()
        for (i in 0 until listOfShapes.size)
            if (listOfShapes[i].borderColor == color)
            {
                listFigures.add(listOfShapes[i])
            }
        return listFigures
    }
    fun findFillColor(color:Color): List<ColorOfShape>
    {
        val listFigures: ArrayList<ColorOfShape> = arrayListOf()
        for (i in 0 until listOfShapes.size)
            if (listOfShapes[i].fillColor == color)
                listFigures.add(listOfShapes[i])
        return listFigures
    }
    fun returnList(): List<ColorOfShape>
    {
        if (listOfShapes.isEmpty())
        {
            throw error ("List is empty")
        }
        else {
            return listOfShapes
        }
    }
    fun counter():Int{
        return listOfShapes.size
    }
    fun fillColorMap():Map<Color,List<ColorOfShape>>
    {
        return listOfShapes.groupBy {it.fillColor }
    }
    fun borderColorMap():Map<Color,List<ColorOfShape>>
    {
        return listOfShapes.groupBy {it.borderColor }
    }
    fun returnType(nameOfFigure: String): List<ColorOfShape>
    {
        val figure: ArrayList<ColorOfShape> = arrayListOf()
        for (i in 0 until listOfShapes.size)
        {
            if (listOfShapes[i].javaClass.name == nameOfFigure)
            {
                figure.add(listOfShapes[i])
            }
        }
        return figure
    }
}