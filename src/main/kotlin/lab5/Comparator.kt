package lab5

import lab2.ColorOfShape
import kotlin.Comparator

class Comparator: Comparator<ColorOfShape> {
    override fun compare(figureOne: ColorOfShape, figureSec: ColorOfShape): Int {
        if (figureOne.square() < figureSec.square()) {
            return -1
        }
        if (figureOne.square() == figureSec.square()) {
            return 0
        }
        return 1
    }
}