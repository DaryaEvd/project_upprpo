package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.enums.ShapeType;

public final class Parallelogram extends AngularShape {
    public Parallelogram(Double base, Double side, Double angle) {
        super(base, side, angle);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Parallelogram;
    }
}
