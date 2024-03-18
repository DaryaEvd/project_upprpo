package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class SquareTest {

    @Test
    public void testGetShapeType(){
        Square square = new Square(10.);
        assertEquals(ShapeType.Square, square.getShapeType());
    }
}
