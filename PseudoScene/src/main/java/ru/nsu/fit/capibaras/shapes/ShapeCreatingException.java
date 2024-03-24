package ru.nsu.fit.capibaras.shapes;

public class ShapeCreatingException extends Exception {
    private ShapeCreatingException(String message) {
        super(message);
    }

    static ShapeCreatingException duplicateOption(double firstSide, double secondSide, double thirdSide) {
        return new ShapeCreatingException(String.format("Triangle with parameters: %f, %f, %f doesn't exist",
                firstSide, secondSide, thirdSide));
    }
}
