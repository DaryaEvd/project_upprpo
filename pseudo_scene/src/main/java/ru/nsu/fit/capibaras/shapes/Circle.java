package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.Collection;

public final class Circle implements Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Circle;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("Radius", radius.toString()));
    }

    @Override
    public Double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public Double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

}
