package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class Rectangle extends Shape {
    private Double base;
    private Double side;

    public Rectangle(Double base, Double side) {
        this.base = base;
        this.side = side;
    }

    public static Rectangle create(double base, double side) throws ShapeCreatingException {
        if (base < 0 || side < 0) {
            throw ShapeCreatingException.negativeParameterValue();
        }
        return new Rectangle(base, side);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = new ArrayList<>(Arrays.asList(
                new Characteristic("Base", base.toString()),
                new Characteristic("Side", side.toString())));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public Double getArea() {
        return base * side;
    }

    @Override
    public Double getPerimeter() {
        return 2 * (side + base);
    }

    public Double getSide() {
        return side;
    }

    public Double getBase() {
        return base;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public void setBase(Double base) {
        this.base = base;
    }
}
