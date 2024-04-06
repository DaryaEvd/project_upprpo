package ru.nsu.fit.capibaras;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
    private final static String NON_NUMERIC_VALE = "sad";
    @Mock
    ClientDataService clientDataService;
    @InjectMocks
    Controller controller;

    @Test
    void testShapesNamesList() {
        List<String> actualShapesNamesList = controller.getShapesNamesList();
        List<String> expectedShapesNamesList =
                Arrays.stream(ShapeType.values()).map(s -> s.name().toLowerCase()).toList();
        assertEquals(expectedShapesNamesList, actualShapesNamesList);
    }

    @Test
    void testNonNumericParametersCircle() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postCircle("5", NON_NUMERIC_VALE));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.",
                thrown.getMessage());
    }

    @Test
    void testNonNumericParametersEllipse() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postEllipse("5", NON_NUMERIC_VALE, "8"));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.",
                thrown.getMessage());
    }

    @Test
    void testNonNumericParametersRectangle() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postRectangle("5", NON_NUMERIC_VALE, "9"));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.",
                thrown.getMessage());
    }

    @Test
    void testNonNumericParametersParallelogram() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postParallelogram("5", NON_NUMERIC_VALE, "8", NON_NUMERIC_VALE));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.",
                thrown.getMessage());
    }

    @Test
    void testNonNumericParametersSquare() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postSquare("5", NON_NUMERIC_VALE));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.", thrown.getMessage());
    }

    @Test
    void testNonNumericParametersRhombus() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postRhombus("5", NON_NUMERIC_VALE, "90"));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.", thrown.getMessage());
    }

    @Test
    void testNonNumericParametersTriangle() {
        Throwable thrown = assertThrows(ShapeCreatingException.class, () ->
                controller.postTriangle("5", NON_NUMERIC_VALE, "89", "89"));

        assertEquals("It's impossible to create shape with a non-numeric parameter value.", thrown.getMessage());
    }
}