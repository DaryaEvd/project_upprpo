package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class CircleTest {

    @Test
    public void testGetShapeType(){
        Circle circle = new Circle(10.);
        assertEquals(ShapeType.Circle, circle.getShapeType());
    }
}