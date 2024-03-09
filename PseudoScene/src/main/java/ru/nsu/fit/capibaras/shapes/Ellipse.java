package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Ellipse extends RoundedShape {
    public Ellipse(Double majorAxis, Double minorAxis) {
        super(majorAxis, minorAxis);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Ellipse;
    }
}
