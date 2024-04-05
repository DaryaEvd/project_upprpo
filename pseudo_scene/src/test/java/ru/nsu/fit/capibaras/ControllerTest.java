package ru.nsu.fit.capibaras;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.nsu.fit.capibaras.enums.ShapeType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ControllerTest {
    @InjectMocks
    Controller controller;

    @Test
    void testShapesNamesList() {
        List<String> actualShapesNamesList = controller.getShapesNamesList();
        List<String> expectedShapesNamesList =
                Arrays.stream(ShapeType.values()).map(s -> s.name().toLowerCase()).toList();
        assertEquals(expectedShapesNamesList, actualShapesNamesList);
    }
}