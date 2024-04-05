package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class RhombusTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Rhombus rhombus = Rhombus.create(10., 30.);
        assertEquals(ShapeType.RHOMBUS, rhombus.getShapeType());
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Rhombus.create(-5., 90.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @Test
    public void testWrongAngleParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Rhombus.create(5., 990.));

        assertEquals("Wrong angle value. Possible values are from 0 to 180 excluding.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,30.,50.", "20.,20.,136.808", "15.,22.5,86.104", "30.,45.,636.396", "3.5,70.78,11.567"}
    )
    void testAreaValue(double side, double angle, double expected) throws ShapeCreatingException {
        Rhombus rhombus = Rhombus.create(side, angle);
        assertEquals(expected, roundToThousandths(rhombus.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,30.,40.", "20.,20.,80.", "15.,22.5,60.", "30.,45.,120.", "3.5,70.78,14.", "3.3,1.2,13.2"}
    )
    void testPerimeterValue(double side, double angle, double expected) throws ShapeCreatingException {
        Rhombus rhombus = Rhombus.create(side, angle);
        assertEquals(expected, roundToThousandths(rhombus.getPerimeter()));
    }
}
