package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class RectangleTest {

    @Test
    public void testGetShapeType() {
        Rectangle rectangle = new Rectangle(10., 10.);
        assertEquals(ShapeType.Rectangle, rectangle.getShapeType());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,30.", "20.,1.,20.", "15.,15.,225.", "30.,1.5,45.", "35.,2.,70."}
    )
    void testAreaValue(double base, double side, double expected) {
        Rectangle rectangle = new Rectangle(base, side);
        assertEquals(expected, roundToThousandths(rectangle.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,3.,26.", "20.,1.,42.", "15.,15.,60.", "30.,1.5,63.", "35.,2.,74.", "3.5,1.2,9.4"}
    )
    void testPerimeterValue(double base, double side, double expected) {
        Rectangle rectangle = new Rectangle(base, side);
        assertEquals(expected, roundToThousandths(rectangle.getPerimeter()));
    }

}
