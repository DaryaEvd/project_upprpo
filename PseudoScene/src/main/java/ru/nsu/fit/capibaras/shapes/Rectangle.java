package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Rectangle extends AngularShape {
    public Rectangle(Double base, Double side) {
        super(base, side, 90.);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Rectangle;
    }
}
