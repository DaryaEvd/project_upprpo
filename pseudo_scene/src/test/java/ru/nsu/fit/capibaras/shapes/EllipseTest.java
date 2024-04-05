package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class EllipseTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Ellipse ellipse = Ellipse.create(10., 11.);
        assertEquals(ShapeType.ELLIPSE, ellipse.getShapeType());
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Ellipse.create(-5., -7.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,20.,628.319", "20.,22.,1382.301", "1.,1.,3.142", "30.,1.,94.248", "35.,6.,659.734", "1.5, 3.5,16.493"}
    )
    void testAreaValue(double minorAxis, double majorAxis, double expected) throws ShapeCreatingException {
        Ellipse ellipse = Ellipse.create(minorAxis, majorAxis);
        assertEquals(expected, roundToThousandths(ellipse.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,20.,99.346", "20.,22.,132.096", "1.,1.,6.283", "30.,1.,133.361", "35.,6.,157.769", "1.5, 3.5,16.918"}
    )
    void testPerimeterValue(double minorAxis, double majorAxis, double expected) throws ShapeCreatingException {
        Ellipse ellipse = Ellipse.create(minorAxis, majorAxis);
        assertEquals(expected, roundToThousandths(ellipse.getPerimeter()));
    }
}
