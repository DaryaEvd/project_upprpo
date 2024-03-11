package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Rectangle extends AngularShape {
    public Rectangle(Double base, Double side, Double angle) {
        super(base, side, angle);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Rectangle;
    }
}
