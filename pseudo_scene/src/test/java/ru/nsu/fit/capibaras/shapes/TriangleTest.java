package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class TriangleTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Triangle triangle = Triangle.create(10., 10., 9.);
        assertEquals(ShapeType.TRIANGLE, triangle.getShapeType());
    }

    @Test
    public void testNotExistingTriangle() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Triangle.create(10., 10., 20.));

        assertEquals("Triangle with parameters: 10, 10, 20 doesn't exist", thrown.getMessage());
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Triangle.create(-5., -7., 90.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,10.,23.", "20.,1.,20.5,41.5", "15.,15.,2.1,32.1", "30.,1.5,29.,60.5", "9.,2.,10.,21.", "3.5,1.2,3.,7.7"}
    )
    void testPerimeterValue(double firstSide, double secondsSide, double thirdSide, double expected) throws ShapeCreatingException {
        Triangle triangle = Triangle.create(firstSide, secondsSide, thirdSide);
        assertEquals(expected, roundToThousandths(triangle.getPerimeter()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,10.,14.83", "20.,1.,20.5,8.766", "15.,15.,2.1,15.711", "30.,1.5,29.,16.486", "9.,2.,10.,8.182", "3.5,1.2,3.,1.742"}
    )
    void testAreaValue(double firstSide, double secondsSide, double thirdSide, double expected) throws ShapeCreatingException {
        Triangle triangle = Triangle.create(firstSide, secondsSide, thirdSide);
        assertEquals(expected, roundToThousandths(triangle.getArea()));
    }

}
