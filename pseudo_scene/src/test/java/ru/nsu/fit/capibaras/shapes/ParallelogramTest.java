package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class ParallelogramTest {

    @Test
    public void testGetShapeType() throws ShapeCreatingException {
        Parallelogram parallelogram = Parallelogram.create(10., 10., 30.);
        assertEquals(ShapeType.PARALLELOGRAM, parallelogram.getShapeType());
    }

    @Test
    public void testNegativeParameters() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                Parallelogram.create(-5., -7., 90.));

        assertEquals("Can't create shape with negative parameters.", thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,30.,15.", "20.,1.,20.,6.84", "15.,15.,22.5,86.104", "30.,1.5,45.,31.82", "35.,2.,70.78,66.098"}
    )
    void testAreaValue(double base, double side, double angle, double expected) throws ShapeCreatingException {
        Parallelogram parallelogram = Parallelogram.create(base, side, angle);
        assertEquals(expected, roundToThousandths(parallelogram.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,30.,26.", "20.,1.,20.,42.", "15.,15.,22.5,60.", "30.,1.5,45.,63.", "35.,2.,70.78,74.", "3.5,1.2,20,9.4"}
    )
    void testPerimeterValue(double base, double side, double angle, double expected) throws ShapeCreatingException {
        Parallelogram parallelogram = Parallelogram.create(base, side, angle);
        assertEquals(expected, roundToThousandths(parallelogram.getPerimeter()));
    }
}
