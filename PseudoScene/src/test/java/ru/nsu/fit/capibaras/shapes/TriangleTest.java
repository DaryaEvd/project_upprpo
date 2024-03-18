package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class TriangleTest {

    @Test
    public void testGetShapeType(){
        Triangle triangle = new Triangle(10., 10., 30.);
        assertEquals(ShapeType.Triangle, triangle.getShapeType());
    }
}
