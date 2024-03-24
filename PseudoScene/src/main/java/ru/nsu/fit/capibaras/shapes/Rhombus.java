package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Rhombus extends QuadrangularShape {
    public Rhombus(Double side, Double angle) {
        super(side, side, angle);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Rhombus;
    }
}
