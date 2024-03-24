package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Square extends QuadrangularShape {
    public Square(Double side) {
        super(side, side, 90.);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Square;
    }
}
