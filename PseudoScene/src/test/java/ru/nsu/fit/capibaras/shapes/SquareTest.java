package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.nsu.fit.capibaras.shapes.TestUtils.roundToThousandths;

public class SquareTest {

    @Test
    public void testGetShapeType() {
        Square square = new Square(10.);
        assertEquals(ShapeType.Square, square.getShapeType());
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,100.", "20.,400.", "15.,225.", "1.5,2.25", "35.,1225.", "25.5,650.25"}
    )
    void testAreaValue(double side, double expected) {
        Square square = new Square(side);
        assertEquals(expected, roundToThousandths(square.getArea()));
    }

    @ParameterizedTest
    @CsvSource(
            {"10.,40.", "20.,80.", "15.,60.", "30.,120.", "3.5,14.", "3.3,13.2"}
    )
    void testPerimeterValue(double side, double expected) {
        Square square = new Square(side);
        assertEquals(expected, roundToThousandths(square.getPerimeter()));
    }
}
