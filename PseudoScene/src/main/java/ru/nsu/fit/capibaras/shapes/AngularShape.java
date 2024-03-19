package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;

import java.util.Arrays;
import java.util.Collection;

public abstract sealed class AngularShape implements Shape permits Parallelogram, Rectangle, Rhombus, Square, Triangle {
    protected Double base;
    protected Double side;
    protected Double angle;

    public AngularShape(Double base, Double side, Double angle) {
        this.base = base;
        this.side = side;
        this.angle = Math.toRadians(angle);
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("Base", base.toString()),
                new Characteristic("Side", side.toString()),
                new Characteristic("Angle", angle.toString())
        );
    }

    @Override
    public Double getArea() {
        return base * side * Math.sin(angle);
    }

    @Override
    public Double getPerimeter() {
        return 2 * (side + base);
    }
}
