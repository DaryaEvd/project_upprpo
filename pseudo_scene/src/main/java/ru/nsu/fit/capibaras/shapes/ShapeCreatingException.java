package ru.nsu.fit.capibaras.shapes;

import java.text.DecimalFormat;

public class ShapeCreatingException extends Exception {
    private ShapeCreatingException(String message) {
        super(message);
    }

    static ShapeCreatingException notExistingTriangle(double firstSide, double secondSide, double thirdSide) {
        DecimalFormat df = new DecimalFormat("#.##");
        return new ShapeCreatingException(String.format("Triangle with parameters: %s, %s, %s doesn't exist",
                df.format(firstSide), df.format(secondSide), df.format(thirdSide)));
    }

    static ShapeCreatingException negativeParameterValue() {
        return new ShapeCreatingException("Can't create shape with negative parameters.");
    }
}
