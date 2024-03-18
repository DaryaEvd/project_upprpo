package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class RhombusTest {

    @Test
    public void testGetShapeType(){
        Rhombus rhombus = new Rhombus(10., 30.);
        assertEquals(ShapeType.Rhombus, rhombus.getShapeType());
    }

}
