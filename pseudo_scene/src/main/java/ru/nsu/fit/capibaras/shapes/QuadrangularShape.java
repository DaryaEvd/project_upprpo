package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;

import java.util.Arrays;
import java.util.Collection;

public abstract sealed class QuadrangularShape extends Shape permits Parallelogram, Rectangle, Rhombus, Square {
    private Double base;
    private Double side;
    private Double angle;

    public QuadrangularShape(Double base, Double side, Double angle) {
        this.base = base;
        this.side = side;
        this.angle = Math.toRadians(angle);
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = Arrays.asList(
                new Characteristic("Base", base.toString()),
                new Characteristic("Side", side.toString()),
                new Characteristic("Angle", String.valueOf(Math.toDegrees(angle))));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public Double getArea() {
        return base * side * Math.sin(angle);
    }

    @Override
    public Double getPerimeter() {
        return 2 * (side + base);
    }

    public Double getBase() {
        return base;
    }

    public Double getAngle() {
        return angle;
    }

    public Double getSide() {
        return side;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public void setSide(Double side) {
        this.side = side;
    }
}
