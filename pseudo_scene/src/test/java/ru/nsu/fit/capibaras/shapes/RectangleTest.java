package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class RectangleTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Rectangle rectangle = Rectangle.create(10., 10.);
        assertEquals(ShapeType.RECTANGLE, rectangle.getShapeType());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,30.", "20.,1.,20.", "15.,15.,225.", "30.,1.5,45.", "35.,2.,70."}
    )
    void testAreaValue(double base, double side, double expected) throws ShapeCreatingException {
        Rectangle rectangle = Rectangle.create(base, side);
        assertEquals(expected, roundToThousandths(rectangle.getArea()));
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Rectangle.create(-5., -7.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,26.", "20.,1.,42.", "15.,15.,60.", "30.,1.5,63.", "35.,2.,74.", "3.5,1.2,9.4"}
    )
    void testPerimeterValue(double base, double side, double expected) throws ShapeCreatingException {
        Rectangle rectangle = Rectangle.create(base, side);
        assertEquals(expected, roundToThousandths(rectangle.getPerimeter()));
    }

}
