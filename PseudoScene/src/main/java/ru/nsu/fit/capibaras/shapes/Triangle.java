package ru.nsu.fit.capibaras.shapes;

import ru.nsu.fit.capibaras.dtos.Characteristic;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.Collection;

public final class Triangle implements Shape {
    private final static double FULL_ANGLE_RADIANS = Math.PI;
    private final Double firstSide;
    private final Double secondSide;
    private final Double thirdSide;
    private final Double oppositeFirstSideAngleDegree;
    private final Double oppositeSecondSideAngleDegree;
    private final Double oppositeThirdSideAngleDegree;

    //TODO: проверка что треугольник с такими сторонами вообще существует
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

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Triangle;
    }

    @Override
    public Collection<Characteristic> getCharacteristics() {
        return Arrays.asList(
                new Characteristic("First side", firstSide.toString()),
                new Characteristic("Angle opposite the first side", oppositeFirstSideAngleDegree.toString()),
                new Characteristic("Second side", secondSide.toString()),
                new Characteristic("Angle opposite the second side", oppositeSecondSideAngleDegree.toString()),
                new Characteristic("Third side", thirdSide.toString()),
                new Characteristic("Angle opposite the third side", oppositeThirdSideAngleDegree.toString())
        );
    }

    @Override
    public Double getArea() {
        return 0.5 * firstSide * secondSide * Math.sin(Math.toRadians(oppositeThirdSideAngleDegree));
    }

    @Override
    public Double getPerimeter(){
        return firstSide + secondSide + thirdSide;
    }
}
