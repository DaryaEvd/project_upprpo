package ru.nsu.fit.capibaras;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import ru.nsu.fit.capibaras.shapes.Shape;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.*;

@Service
public class ClientDataManager {
    private final static Path CLIENT_DATA_FILE = Path.of("pseudo_scene", "src", "main",
            "resources", "client_data", "client_data.json");
    private final Map<String, List<Shape>> clientData;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Shape.class, new CustomShapeDeserializer()).create();

    public ClientDataManager() {
        Map<String, List<Shape>> data;
        try (Reader reader = new FileReader(CLIENT_DATA_FILE.toString())) {
            Type type = new TypeToken<Map<String, List<Shape>>>() {
            }.getType();
            data = gson.fromJson(reader, type);
            data = Objects.requireNonNullElseGet(data, HashMap::new);
        } catch (IOException e) {
            data = new HashMap<>();
        }
        clientData = data;
    }

    public List<Shape> getShapes(String clientId) {
        List<Shape> shapes = clientData.get(clientId);
        if (shapes == null) {
            return new ArrayList<>();
        }
        return clientData.get(clientId);
    }

    public void saveShape(String clientId, Shape shape) {
        List<Shape> clientShapes = clientData.get(clientId);
        if (clientShapes == null) {
            ArrayList<Shape> newArrayList = new ArrayList<>();
            newArrayList.add(shape);
            clientData.put(clientId, newArrayList);
        } else {
            clientShapes.add(shape);
        }
        try (Writer writer = new FileWriter(CLIENT_DATA_FILE.toString())) {
            gson.toJson(clientData, writer);
        } catch (IOException e) {
            //TODO
        }
    }
}
