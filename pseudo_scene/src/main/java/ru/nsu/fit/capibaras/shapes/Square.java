package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class Square extends Shape {
    private Double side;

    public Square(Double side) {
        this.side = side;
    }

    public static Square create(double side) throws ShapeCreatingException {
        if (side < 0) {
            throw ShapeCreatingException.negativeParameterValue();
        }
        if (side == 0) {
            throw ShapeCreatingException.zeroParameterValue();
        }
        return new Square(side);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.SQUARE;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = new ArrayList<>(
                Collections.singleton(new Characteristic("Side", side.toString())));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public Double getArea() {
        return side * side;
    }

    @Override
    public Double getPerimeter() {
        return 4 * side;
    }

    public Double getSide() {
        return side;
    }

    public void setSide(Double side) {
        this.side = side;
    }
}
