package ru.nsu.fit.capibaras.shapes;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.enums.ShapeType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    public void testGetShapeType(){
        Triangle triangle = new Triangle(10., 10., 30.);
        assertEquals(ShapeType.Triangle, triangle.getShapeType());
    }

    //TODO: тесты для площади и периметра будут написаны когда-нибудь потом
}
