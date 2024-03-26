package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.Collection;

public final class Parallelogram extends Shape {
    private Double base;
    private Double side;
    private Double angle;

    public Parallelogram(Double base, Double side, Double angle) {
        this.angle = angle;
        this.side = side;
        this.base = base;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Parallelogram;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = Arrays.asList(
                new Characteristic("Base", base.toString()),
                new Characteristic("Side", side.toString()),
                new Characteristic("Angle", angle.toString()));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public Double getArea() {
        return base * side * Math.sin(Math.toRadians(angle));
    }

    @Override
    public Double getPerimeter() {
        return 2 * (side + base);
    }

    public Double getSide() {
        return side;
    }

    public Double getBase() {
        return base;
    }

    public Double getAngle() {
        return angle;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }
}
