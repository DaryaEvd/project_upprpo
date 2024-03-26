package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class Circle extends Shape {
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
        Collection<Characteristic> characteristics = new ArrayList<>(Collections.singleton(
                new Characteristic("Radius", radius.toString())));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
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
