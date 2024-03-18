package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class RectangleTest {

    @Test
    public void testGetShapeType() {
        Rectangle rectangle = new Rectangle(10., 10.);
        assertEquals(ShapeType.Rectangle, rectangle.getShapeType());
    }
}
