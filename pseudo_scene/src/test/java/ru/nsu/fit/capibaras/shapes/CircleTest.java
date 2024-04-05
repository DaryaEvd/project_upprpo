package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class CircleTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Circle circle = Circle.create(10.);
        assertEquals(ShapeType.CIRCLE, circle.getShapeType());
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Circle.create(-5.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,314.159", "20.,1256.637", "1.,3.142", "30.,2827.433", "35.,3848.451", "1.5,7.069"}
    )
    void testAreaValue(double radius, double expected) throws ShapeCreatingException {
        Circle circle = Circle.create(radius);
        assertEquals(expected, roundToThousandths(circle.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,62.832", "20.,125.664", "1.,6.283", "30.,188.496", "35.,219.911", "1.5,9.425"}
    )
    void testPerimeterValue(double radius, double expected) throws ShapeCreatingException {
        Circle circle = Circle.create(radius);
        assertEquals(expected, roundToThousandths(circle.getPerimeter()));
    }
}