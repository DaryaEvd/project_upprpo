package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public final class Triangle extends Shape {
    private final static double FULL_ANGLE_RADIANS = Math.PI;
    private Double firstSide;
    private Double secondSide;
    private Double thirdSide;
    private Double oppositeFirstSideAngleDegree;
    private Double oppositeSecondSideAngleDegree;
    private Double oppositeThirdSideAngleDegree;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;

        double firstSideSquare = firstSide * firstSide;
        double secondSideSquare = secondSide * secondSide;
        double thirdSideSquare = thirdSide * thirdSide;

        double oppositeFirstSideAngleRadians =
                Math.acos((secondSideSquare + thirdSideSquare - firstSideSquare) / (2 * secondSide * thirdSide));
        oppositeFirstSideAngleDegree = Math.toDegrees(oppositeFirstSideAngleRadians);

        double oppositeSecondSideAngleRadians =
                Math.acos((firstSideSquare + thirdSideSquare - secondSideSquare) / (2 * firstSide * thirdSide));
        oppositeSecondSideAngleDegree = Math.toDegrees(oppositeSecondSideAngleRadians);

        oppositeThirdSideAngleDegree =
                Math.toDegrees(FULL_ANGLE_RADIANS - oppositeFirstSideAngleRadians - oppositeSecondSideAngleRadians);
    }

    public static Triangle create(double firstSide, double secondSide, double thirdSide) throws ShapeCreatingException {
        if (firstSide < 0 || secondSide < 0 || thirdSide < 0) {
            throw ShapeCreatingException.negativeParameterValue();
        }
        if (firstSide + secondSide > thirdSide && firstSide + thirdSide > secondSide
                && secondSide + thirdSide > firstSide) {
            return new Triangle(firstSide, secondSide, thirdSide);
        }
        if (firstSide == 0 || secondSide == 0 || thirdSide == 0) {
            throw ShapeCreatingException.zeroParameterValue();
        }
        throw ShapeCreatingException.notExistingTriangle(firstSide, secondSide, thirdSide);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.TRIANGLE;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        Collection<Characteristic> characteristics = new ArrayList<>(Arrays.asList(
                new Characteristic("First side", firstSide.toString()),
                new Characteristic("Angle opposite the first side", oppositeFirstSideAngleDegree.toString()),
                new Characteristic("Second side", secondSide.toString()),
                new Characteristic("Angle opposite the second side", oppositeSecondSideAngleDegree.toString()),
                new Characteristic("Third side", thirdSide.toString()),
                new Characteristic("Angle opposite the third side", oppositeThirdSideAngleDegree.toString())));
        characteristics.addAll(super.getCharacteristics());
        return characteristics;
    }

    @Override
    public Double getArea() {
        return 0.5 * firstSide * secondSide * Math.sin(Math.toRadians(oppositeThirdSideAngleDegree));
    }

    @Override
    public Double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    public Double getFirstSide() {
        return firstSide;
    }

    public Double getSecondSide() {
        return secondSide;
    }

    public Double getThirdSide() {
        return thirdSide;
    }

    public Double getOppositeFirstSideAngleDegree() {
        return oppositeFirstSideAngleDegree;
    }

    public Double getOppositeSecondSideAngleDegree() {
        return oppositeSecondSideAngleDegree;
    }

    public Double getOppositeThirdSideAngleDegree() {
        return oppositeThirdSideAngleDegree;
    }

    public void setFirstSide(Double firstSide) {
        this.firstSide = firstSide;
    }

    public void setSecondSide(Double secondSide) {
        this.secondSide = secondSide;
    }

    public void setThirdSide(Double thirdSide) {
        this.thirdSide = thirdSide;
    }

    public void setOppositeFirstSideAngleDegree(Double oppositeFirstSideAngleDegree) {
        this.oppositeFirstSideAngleDegree = oppositeFirstSideAngleDegree;
    }

    public void setOppositeSecondSideAngleDegree(Double oppositeSecondSideAngleDegree) {
        this.oppositeSecondSideAngleDegree = oppositeSecondSideAngleDegree;
    }

    public void setOppositeThirdSideAngleDegree(Double oppositeThirdSideAngleDegree) {
        this.oppositeThirdSideAngleDegree = oppositeThirdSideAngleDegree;
    }
}
