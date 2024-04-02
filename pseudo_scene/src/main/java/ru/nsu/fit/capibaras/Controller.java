package ru.nsu.fit.capibaras;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;
import ru.nsu.fit.capibaras.shapes.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RestControllerAdvice
public class Controller {

    private final ClientDataService clientDataService;

    public Controller(ClientDataService clientDataService) {
        this.clientDataService = clientDataService;
    }

    @GetMapping("/shape/chosen/list/{clientId}")
    public List<String> getChosenShape(@PathVariable String clientId){
        return clientDataService.getShapes(clientId)
                .stream().map(shape -> shape.getShapeType().name().toLowerCase()).toList();
    }
    @GetMapping("/shape/list/{clientId}")
    public List<Shape> getShapeList(@PathVariable String clientId) {
        return clientDataService.getShapes(clientId);
    }

    @GetMapping("/shape/list")
    public List<String> getShapeList() {
        return Arrays.stream(ShapeType.values())
                .map(shapeType -> shapeType.name().toLowerCase()).toList();
    }


    @DeleteMapping("/shape/{shapeName}")
    public void deleteShape(@RequestParam(value = "client_id") String clientId, @PathVariable String shapeName) {
        System.out.println(shapeName);
        clientDataService.deleteShape(clientId, shapeName);
    }

    @PostMapping("/shape/rectangle")
    public void postRectangle(@RequestParam(value = "client_id") String clientId,
                              @RequestParam(value = "side") double rectangleSide,
                              @RequestParam(value = "base") double rectangleBase) throws ShapeCreatingException {
        Rectangle rectangle = Rectangle.create(rectangleBase, rectangleSide);
        clientDataService.saveShape(clientId, rectangle);
    }

    @PostMapping("/shape/triangle")
    public void postTriangle(@RequestParam(value = "client_id") String clientId,
                             @RequestParam(value = "first_side") double triangleFirstSide,
                             @RequestParam(value = "second_side") double triangleSecondSide,
                             @RequestParam(value = "third_side") double triangleThirdSide)
            throws ShapeCreatingException {
        Triangle triangle = Triangle.create(triangleFirstSide, triangleSecondSide, triangleThirdSide);
        clientDataService.saveShape(clientId, triangle);
    }

    @PostMapping("/shape/parallelogram")
    public void postParallelogram(@RequestParam(value = "client_id") String clientId,
                                  @RequestParam(value = "side") double parallelogramSide,
                                  @RequestParam(value = "base") double parallelogramBase,
                                  @RequestParam(value = "angle") double parallelogramAngle)
            throws ShapeCreatingException {
        Parallelogram parallelogram = Parallelogram.create(parallelogramBase, parallelogramSide, parallelogramAngle);
        clientDataService.saveShape(clientId, parallelogram);
    }

    @PostMapping("/shape/rhombus")
    public void postRhombus(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "side") double rhombusSide,
                            @RequestParam(value = "angle") double rhombusAngle) throws ShapeCreatingException {
        Rhombus rhombus = Rhombus.create(rhombusSide, rhombusAngle);
        clientDataService.saveShape(clientId, rhombus);
    }

    @PostMapping("/shape/circle")
    public void postCircle(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "radius") double circleRadius) throws ShapeCreatingException {
        Circle circle = Circle.create(circleRadius);
        clientDataService.saveShape(clientId, circle);
    }

    @PostMapping("/shape/ellipse")
    public void postEllipse(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "major_axis") double ellipseMajorAxis,
                            @RequestParam(value = "minor_axis") double ellipseMinorAxis) throws ShapeCreatingException {
        Ellipse ellipse = Ellipse.create(ellipseMajorAxis, ellipseMinorAxis);
        clientDataService.saveShape(clientId, ellipse);
    }

    @PostMapping("/shape/square")
    public void postSquare(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "side") double squareSide) throws ShapeCreatingException {
        Square square = Square.create(squareSide);
        clientDataService.saveShape(clientId, square);
    }

    @ExceptionHandler(ShapeCreatingException.class)
    public ResponseEntity<ErrorMessage> handleException(ShapeCreatingException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }
}
