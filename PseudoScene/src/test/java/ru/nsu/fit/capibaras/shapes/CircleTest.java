package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CircleTest {

    @Test
    public void testGetShapeType(){
        Circle circle = new Circle(10.);
        assertEquals(ShapeType.Circle, circle.getShapeType());
    }

}