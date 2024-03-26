package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.Collection;

public final class Ellipse implements Shape {
    private Double majorAxis;
    private Double minorAxis;

    public Ellipse(Double majorAxis, Double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("Major axis", majorAxis.toString()),
                new Characteristic("Minor axis", minorAxis.toString()));
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Ellipse;
    }

    @Override
    public Double getArea() {
        return Math.PI * minorAxis * majorAxis;
    }

    @Override
    public Double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((minorAxis * minorAxis + majorAxis * majorAxis) / 2);
    }

    public Double getMajorAxis() {
        return majorAxis;
    }

    public Double getMinorAxis() {
        return minorAxis;
    }

    public void setMajorAxis(Double majorAxis) {
        this.majorAxis = majorAxis;
    }

    public void setMinorAxis(Double minorAxis) {
        this.minorAxis = minorAxis;
    }
}
