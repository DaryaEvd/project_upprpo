package ru.nsu.fit.capibaras;

import org.springframework.stereotype.Service;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.shapes.Shape;

import java.util.*;

@Service
public class ClientDataService {
    private final Map<String, List<Shape>> clientData = new HashMap<>();

    public ClientDataService() {
    }

    public synchronized void deleteShape(String clientId, String shapeName) {
        ShapeType shapeType = ShapeType.valueOf(shapeName.toUpperCase());
        List<Shape> clientShapes = clientData.get(clientId);
        if (clientShapes != null) {
            clientShapes.removeIf(s -> s.getShapeType() == shapeType);
        }
    }

    public synchronized List<Shape> getShapes(String clientId) {
        List<Shape> shapes = clientData.get(clientId);
        if (shapes == null) {
            return new ArrayList<>();
        }
        return clientData.get(clientId);
    }

    public synchronized void saveShape(String clientId, Shape shape) {
        List<Shape> clientShapes = clientData.get(clientId);
        if (clientShapes == null) {
            ArrayList<Shape> newArrayList = new ArrayList<>();
            newArrayList.add(shape);
            clientData.put(clientId, newArrayList);
        } else {
            clientShapes.removeIf(s -> s.equals(shape));
            clientShapes.add(shape);
        }
    }
}
