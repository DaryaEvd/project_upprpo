package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class ParallelogramTest {

    @Test
    public void testGetShapeType(){
        Parallelogram parallelogram = new Parallelogram(10., 10., 30.);
        assertEquals(ShapeType.Parallelogram, parallelogram.getShapeType());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,30.,15.", "20.,1.,20.,6.84", "15.,15.,22.5, 86.104", "30.,1.5,45.,31.82", "35.,2.,70.78,66.098"}
    )
    void testAreaValue(Double base, Double side, Double angle, Double expected) {
        Parallelogram parallelogram = new Parallelogram(base, side, angle);
        assertEquals(expected, roundToThousandths(parallelogram.getArea()));
    }
}
