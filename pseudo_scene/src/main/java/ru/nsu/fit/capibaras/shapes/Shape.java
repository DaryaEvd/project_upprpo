package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Collection;

public sealed interface Shape permits QuadrangularShape, RoundedShape, Triangle {
    ShapeType getShapeType();

    Collection<Characteristic> getCharacteristics();

    Double getArea();

    Double getPerimeter();
}
