package ru.nsu.fit.capibaras;

import com.google.gson.*;
import ru.nsu.fit.capibaras.shapes.*;

import java.lang.reflect.Type;

class CustomShapeDeserializer implements JsonDeserializer<Shape> {
    @Override
    public Shape deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        if (jsonObject.has("radius")) {
            double radius = jsonObject.get("radius").getAsDouble();
            return new Circle(radius);
        } else if (jsonObject.has("side") && jsonObject.has("base")
                && jsonObject.has("angle")) {
            return getParallelogram(jsonObject);
        } else if (jsonObject.has("side") && jsonObject.has("base")) {
            return getRectangle(jsonObject);
        } else if (jsonObject.has("side")) {
            return getSquare(jsonObject);
        } else if (jsonObject.has("side") && jsonObject.has("angle")) {
            return getRhombus(jsonObject);
        } else if (jsonObject.has("major_axis") && jsonObject.has("minor_axis")) {
            return getEllipse(jsonObject);
        } else if (jsonObject.has("first_side") && jsonObject.has("second_side")
                && jsonObject.has("third_side")) {
            return getTriangle(jsonObject);
        } else {
            throw new JsonParseException("Unknown shape type");
        }
    }

    private Triangle getTriangle(JsonObject jsonObject) {
        double first_side = jsonObject.get("first_side").getAsDouble();
        double second_side = jsonObject.get("second_side").getAsDouble();
        double third_side = jsonObject.get("third_side").getAsDouble();
        return new Triangle(first_side, second_side, third_side);
    }

    private Ellipse getEllipse(JsonObject jsonObject) {
        double majorAxis = jsonObject.get("major_axis").getAsDouble();
        double minorAxis = jsonObject.get("minor_axis").getAsDouble();
        return new Ellipse(majorAxis, minorAxis);
    }

    private Rhombus getRhombus(JsonObject jsonObject) {
        double side = jsonObject.get("side").getAsDouble();
        double angle = jsonObject.get("angle").getAsDouble();
        return new Rhombus(side, angle);
    }

    private Square getSquare(JsonObject jsonObject) {
        double side = jsonObject.get("side").getAsDouble();
        return new Square(side);
    }

    private Rectangle getRectangle(JsonObject jsonObject) {
        double side = jsonObject.get("side").getAsDouble();
        double base = jsonObject.get("base").getAsDouble();
        return new Rectangle(side, base);
    }

    private Parallelogram getParallelogram(JsonObject jsonObject) {
        double side = jsonObject.get("side").getAsDouble();
        double base = jsonObject.get("base").getAsDouble();
        double angle = jsonObject.get("angle").getAsDouble();
        return new Parallelogram(side, base, angle);
    }
}

