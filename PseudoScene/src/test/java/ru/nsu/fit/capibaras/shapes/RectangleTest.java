package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RectangleTest {

    @Test
    public void testGetShapeType() {
        Rectangle rectangle = new Rectangle(10., 10.);
        assertEquals(ShapeType.Rectangle, rectangle.getShapeType());
    }
}
