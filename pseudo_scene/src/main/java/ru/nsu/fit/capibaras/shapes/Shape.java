package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.Collection;

public sealed abstract class Shape permits Triangle, Circle, Ellipse, Rectangle,
        Square, Parallelogram, Rhombus {
    public abstract ShapeType getShapeType();

    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("Area", String.valueOf(getArea())),
                new Characteristic("Perimeter", String.valueOf(getPerimeter())));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Shape s) {
            return s.getShapeType() == this.getShapeType();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return getShapeType().hashCode();
    }

    public abstract Double getArea();

    public abstract Double getPerimeter();
}
