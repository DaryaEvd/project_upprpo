package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EllipseTest {

    @Test
    public void testGetShapeType(){
        Ellipse ellipse = new Ellipse(10., 11.);
        assertEquals(ShapeType.Ellipse, ellipse.getShapeType());
    }
}
