package ru.nsu.fit.capibaras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.shapes.*;

import java.util.Arrays;
import java.util.List;

import static ru.nsu.fit.capibaras.Main.CLIENT_DATA_MANAGER;


@RestController
public class Controller {
    @GetMapping("/shape/list")
    public List<Shape> getShapeLists(@RequestParam(value = "client_id") String clientId) {
        return CLIENT_DATA_MANAGER.getShapes(clientId);
    }

    @PostMapping("/shape/list")
    public List<String> getShapeLists() {
        return Arrays.stream(ShapeType.values()).map(Enum::name).toList();
    }

    @PostMapping("/shape/rectangle")
    public void getRectangle(@RequestParam(value = "client_id") String clientId,
                             @RequestParam(value = "side") double rectangleSide,
                             @RequestParam(value = "base") double rectangleBase) throws ShapeCreatingException {
        Rectangle rectangle = Rectangle.create(rectangleBase, rectangleSide);
        CLIENT_DATA_MANAGER.saveShape(clientId, rectangle);
    }

    @PostMapping("/shape/triangle")
    public void getTriangle(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "first_side") double triangleFirstSide,
                            @RequestParam(value = "second_side") double triangleSecondSide,
                            @RequestParam(value = "third_side") double triangleThirdSide)
            throws ShapeCreatingException {
        Triangle triangle = Triangle.create(triangleFirstSide, triangleSecondSide, triangleThirdSide);
        CLIENT_DATA_MANAGER.saveShape(clientId, triangle);
    }

    @PostMapping("/shape/parallelogram")
    public void getParallelogram(@RequestParam(value = "client_id") String clientId,
                                 @RequestParam(value = "side") double parallelogramSide,
                                 @RequestParam(value = "base") double parallelogramBase,
                                 @RequestParam(value = "angle") double parallelogramAngle)
            throws ShapeCreatingException {
        Parallelogram parallelogram = Parallelogram.create(parallelogramBase, parallelogramSide, parallelogramAngle);
        CLIENT_DATA_MANAGER.saveShape(clientId, parallelogram);
    }

    @PostMapping("/shape/rhombus")
    public void getRhombus(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "side") double rhombusSide,
                           @RequestParam(value = "angle") double rhombusAngle) throws ShapeCreatingException {
        Rhombus rhombus = Rhombus.create(rhombusSide, rhombusAngle);
        CLIENT_DATA_MANAGER.saveShape(clientId, rhombus);
    }

    @PostMapping("/shape/circle")
    public void getCircle(@RequestParam(value = "client_id") String clientId,
                          @RequestParam(value = "radius") double circleRadius) throws ShapeCreatingException {
        Circle circle = Circle.create(circleRadius);
        CLIENT_DATA_MANAGER.saveShape(clientId, circle);
    }

    @PostMapping("/shape/ellipse")
    public void getEllipse(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "major_axis") double ellipseMajorAxis,
                           @RequestParam(value = "minor_axis") double ellipseMinorAxis) throws ShapeCreatingException {
        Ellipse ellipse = Ellipse.create(ellipseMajorAxis, ellipseMinorAxis);
        CLIENT_DATA_MANAGER.saveShape(clientId, ellipse);
    }

    @PostMapping("/shape/square")
    public void getSquare(@RequestParam(value = "client_id") String clientId,
                          @RequestParam(value = "side") double squareSide) throws ShapeCreatingException {
        Square square = Square.create(squareSide);
        CLIENT_DATA_MANAGER.saveShape(clientId, square);
    }

}
