package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class EllipseTest {

    @Test
    public void testGetShapeType(){
        Ellipse ellipse = new Ellipse(10., 11.);
        assertEquals(ShapeType.Ellipse, ellipse.getShapeType());
    }
}
