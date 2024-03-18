package ru.nsu.fit.capibaras.shapes;

import org.junit.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static junit.framework.TestCase.assertEquals;

public class ParallelogramTest {

    @Test
    public void testGetShapeType(){
        Parallelogram parallelogram = new Parallelogram(10., 10., 30.);
        assertEquals(ShapeType.Parallelogram, parallelogram.getShapeType());
    }
}
