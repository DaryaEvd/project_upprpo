package ru.nsu.fit.capibaras.exception;

import java.text.DecimalFormat;

public class ShapeCreatingException extends Exception {
    private ShapeCreatingException(String message) {
        super(message);
    }

    public static ShapeCreatingException notExistingTriangle(double firstSide, double secondSide, double thirdSide) {
        DecimalFormat df = new DecimalFormat("#.##");
        return new ShapeCreatingException(String.format("Triangle with parameters: %s, %s, %s doesn't exist",
                df.format(firstSide), df.format(secondSide), df.format(thirdSide)));
    }

    public static ShapeCreatingException nonNumericParameterValue() {
        return new ShapeCreatingException("It's impossible to create shape with a non-numeric parameter value.");
    }

    public static ShapeCreatingException negativeParameterValue() {
        return new ShapeCreatingException("Can't create shape with negative parameters.");
    }

    public static ShapeCreatingException wrongAngleValue() {
        return new ShapeCreatingException("Wrong angle value. Possible values are from 0 to 180 excluding.");
    }
}
