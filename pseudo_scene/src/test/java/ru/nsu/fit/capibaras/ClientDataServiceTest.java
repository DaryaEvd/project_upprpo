package ru.nsu.fit.capibaras;

import org.junit.jupiter.api.Test;
import ru.nsu.fit.capibaras.shapes.Circle;
import ru.nsu.fit.capibaras.shapes.Rectangle;
import ru.nsu.fit.capibaras.shapes.Square;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientDataServiceTest {
    private final ClientDataService clientDataService = new ClientDataService();

    @Test
    void testAddNewShape() {
        clientDataService.saveShape("8", new Circle(9.));
        assertEquals(List.of(new Circle(9.)), clientDataService.getShapes("8"));
    }

    @Test
    void testDeleteShape() {
        clientDataService.saveShape("9", new Circle(9.));
        clientDataService.saveShape("9", new Rectangle(9., 8.));
        clientDataService.deleteShape("9", "circle");
        assertEquals(List.of(new Rectangle(9., 8.)), clientDataService.getShapes("9"));
    }

    @Test
    void testEmptyShapesList() {
        assertEquals(List.of(), clientDataService.getShapes("10"));
    }

    @Test
    void testGettingShapesList() {
        clientDataService.saveShape("1", new Circle(9.));
        clientDataService.saveShape("1", new Rectangle(9., 8.));
        clientDataService.saveShape("1", new Square(9.));
        assertEquals(List.of(new Circle(9.), new Rectangle(9., 8.), new Square(9.)),
                clientDataService.getShapes("1"));
    }
}