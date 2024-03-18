package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RhombusTest {

    @Test
    public void testGetShapeType(){
        Rhombus rhombus = new Rhombus(10., 30.);
        assertEquals(ShapeType.Rhombus, rhombus.getShapeType());
    }

}
