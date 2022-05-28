package lab6

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import lab2.*
import java.io.File
import java.io.FileWriter

class Serialization {
    private val json = Json {
        prettyPrint = true
        serializersModule = SerializersModule {
            polymorphic(ColorOfShape::class) {
                subclass(Circle::class)
                subclass(Rectangle::class)
                subclass(Triangle::class)
                subclass(Foursquare::class)
            }
        }
    }

    private fun serialize(shapes: List<ColorOfShape>): String {
        return json.encodeToString(shapes)
    }
    private fun deserialize(string: String): List<ColorOfShape> {
        return json.decodeFromString(string)
    }
    fun readFromFile(way: String): List<ColorOfShape> {
        val file = File(way)
        return deserialize(file.readText())
    }
    fun writeToFile(way: String, shape: List<ColorOfShape>) {
        FileWriter(way).buffered().use { writer ->
            writer.write(serialize(shape))
        }
    }
}