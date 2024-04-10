package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class Ellipse extends Shape {
    private Double majorAxis;
    private Double minorAxis;

    public Ellipse(Double majorAxis, Double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    public static Ellipse create(double majorAxis, double minorAxis) throws ShapeCreatingException {
        if (minorAxis < 0 || majorAxis < 0) {
            throw ShapeCreatingException.negativeParameterValue();
        }
        if (minorAxis == 0 || majorAxis == 0) {
            throw ShapeCreatingException.zeroParameterValue();
        }
        return new Ellipse(majorAxis, minorAxis);
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = new ArrayList<>(Arrays.asList(
                new Characteristic("Major axis", majorAxis.toString()),
                new Characteristic("Minor axis", minorAxis.toString())));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.ELLIPSE;
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
