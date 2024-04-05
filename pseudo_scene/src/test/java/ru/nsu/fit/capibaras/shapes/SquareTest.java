package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class SquareTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Square square = Square.create(10.);
        assertEquals(ShapeType.SQUARE, square.getShapeType());
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Square.create(-5.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,100.", "20.,400.", "15.,225.", "1.5,2.25", "35.,1225.", "25.5,650.25"}
    )
    void testAreaValue(double side, double expected) throws ShapeCreatingException {
        Square square = Square.create(side);
        assertEquals(expected, roundToThousandths(square.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,40.", "20.,80.", "15.,60.", "30.,120.", "3.5,14.", "3.3,13.2"}
    )
    void testPerimeterValue(double side, double expected) throws ShapeCreatingException {
        Square square = Square.create(side);
        assertEquals(expected, roundToThousandths(square.getPerimeter()));
    }
}
