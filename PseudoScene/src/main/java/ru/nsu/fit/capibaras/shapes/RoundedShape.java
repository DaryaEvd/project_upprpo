package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;

import java.util.Arrays;
import java.util.Collection;

public abstract class RoundedShape implements Shape {
    protected Double majorAxis;
    protected Double minorAxis;

    public RoundedShape(Double majorAxis, Double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("Major axis", majorAxis.toString()),
                new Characteristic("Minor axis", minorAxis.toString())
        );
    }

    @Override
    public Double getArea() {
        return Math.PI * minorAxis * majorAxis;
    }

    @Override
    public Double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((minorAxis * minorAxis + majorAxis * majorAxis) / 2);
    }
}
