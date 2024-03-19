package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.Collection;

public final class Triangle extends AngularShape {
    private final Double otherSide;

    public Triangle(Double base, Double side, Double angle) {
        super(base, side, angle);
        otherSide = Math.sqrt(base * base + side * side - 2 * base * side * Math.cos(this.angle));
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Triangle;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("First side", base.toString()),
                new Characteristic("Second side", side.toString()),
                new Characteristic("Third side", otherSide.toString()),
                new Characteristic("Angle between First and Second sides", angle.toString())
        );
    }

    @Override
    public Double getArea() {
        return super.getArea() / 2;
    }

    @Override
    public Double getPerimeter(){
        return super.base + super.side + otherSide;
    }
}
