package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Circle extends RoundedShape {

    public Circle(Double radius) {
        super(radius, radius);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Circle;
    }
}
