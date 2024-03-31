package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class Rhombus extends Shape {
    private Double side;
    private Double angle;

    private Rhombus(Double side, Double angle) {
        this.side = side;
        this.angle = angle;
    }

    public static Rhombus create(double side, double angle) throws ShapeCreatingException {
        if (side < 0 || angle < 0) {
            throw ShapeCreatingException.negativeParameterValue();
        }
        return new Rhombus(side, angle);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Rhombus;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = new ArrayList<>(Arrays.asList(
                new Characteristic("Side", side.toString()),
                new Characteristic("Angle", String.valueOf(Math.toDegrees(angle)))));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public Double getArea() {
        return side * side * Math.sin(Math.toRadians(angle));
    }

    @Override
    public Double getPerimeter() {
        return 4 * side;
    }

    public Double getAngle() {
        return angle;
    }

    public Double getSide() {
        return side;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public void setSide(Double side) {
        this.side = side;
    }
}
