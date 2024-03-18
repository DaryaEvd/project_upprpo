package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParallelogramTest {

    @Test
    public void testGetShapeType(){
        Parallelogram parallelogram = new Parallelogram(10., 10., 30.);
        assertEquals(ShapeType.Parallelogram, parallelogram.getShapeType());
    }
}
