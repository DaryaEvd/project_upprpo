package ru.nsu.fit.capibaras;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.fit.capibaras.enums.ShapeType;
import ru.nsu.fit.capibaras.exception.ShapeCreatingException;
import ru.nsu.fit.capibaras.shapes.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RestControllerAdvice
public class Controller {

    private final ClientDataService clientDataService;

    public Controller(ClientDataService clientDataService) {
        this.clientDataService = clientDataService;
    }

    @Operation(summary = "Get a list of set shapes' names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of shapes' names set by the client")
    })
    @GetMapping("/shape/chosen/names_list/{clientId}")
    public List<String> getChosenShape(@PathVariable String clientId) {
        return clientDataService.getShapes(clientId)
                .stream().map(shape -> shape.getShapeType().name().toLowerCase()).toList();
    }

    @Operation(summary = "Get a list of set shapes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of shapes set by the client")
    })
    @GetMapping("/shape/chosen/shapes_list/{clientId}")
    public List<Shape> getShapeList(@PathVariable String clientId) {
        return clientDataService.getShapes(clientId);
    }

    @Operation(summary = "Get a list of existing shapes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a list of existing shapes")
    })
    @GetMapping("/shape/shapes_list")
    public List<String> getShapesNamesList() {
        return Arrays.stream(ShapeType.values())
                .map(shapeType -> shapeType.name().toLowerCase()).toList();
    }

    @Operation(summary = "Delete the specified shape from the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description =
                            "Deleting a specified shape from those set by a specific user was successfully completed")
    })
    @DeleteMapping("/shape/{shapeName}")
    public void deleteShape(@RequestParam(value = "client_id") String clientId, @PathVariable String shapeName) {
        System.out.println(shapeName);
        clientDataService.deleteShape(clientId, shapeName);
    }

    @Operation(summary = "Add a new rectangle to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The rectangle was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/rectangle")
    public void postRectangle(@RequestParam(value = "client_id") String clientId,
                              @RequestParam(value = "side") double rectangleSide,
                              @RequestParam(value = "base") double rectangleBase) throws ShapeCreatingException {
        Rectangle rectangle = Rectangle.create(rectangleBase, rectangleSide);
        clientDataService.saveShape(clientId, rectangle);
    }

    @Operation(summary = "Add a new triangle to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The triangle was successfully added"),
            @ApiResponse(responseCode = "400",
                    description = "Negative parameters were entered or such triangle doesn't exist")
    })
    @PostMapping("/shape/triangle")
    public void postTriangle(@RequestParam(value = "client_id") String clientId,
                             @RequestParam(value = "first_side") double triangleFirstSide,
                             @RequestParam(value = "second_side") double triangleSecondSide,
                             @RequestParam(value = "third_side") double triangleThirdSide)
            throws ShapeCreatingException {
        Triangle triangle = Triangle.create(triangleFirstSide, triangleSecondSide, triangleThirdSide);
        clientDataService.saveShape(clientId, triangle);
    }

    @Operation(summary = "Add a new parallelogram to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The parallelogram was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/parallelogram")
    public void postParallelogram(@RequestParam(value = "client_id") String clientId,
                                  @RequestParam(value = "side") double parallelogramSide,
                                  @RequestParam(value = "base") double parallelogramBase,
                                  @RequestParam(value = "angle") double parallelogramAngle)
            throws ShapeCreatingException {
        Parallelogram parallelogram = Parallelogram.create(parallelogramBase, parallelogramSide, parallelogramAngle);
        clientDataService.saveShape(clientId, parallelogram);
    }

    @Operation(summary = "Add a new rhombus to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The rhombus was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/rhombus")
    public void postRhombus(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "side") double rhombusSide,
                            @RequestParam(value = "angle") double rhombusAngle) throws ShapeCreatingException {
        Rhombus rhombus = Rhombus.create(rhombusSide, rhombusAngle);
        clientDataService.saveShape(clientId, rhombus);
    }

    @Operation(summary = "Add a new circle to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The circle was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/circle")
    public void postCircle(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "radius") double circleRadius) throws ShapeCreatingException {
        Circle circle = Circle.create(circleRadius);
        clientDataService.saveShape(clientId, circle);
    }

    @Operation(summary = "Add a new ellipse to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The ellipse was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/ellipse")
    public void postEllipse(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "major_axis") double ellipseMajorAxis,
                            @RequestParam(value = "minor_axis") double ellipseMinorAxis) throws ShapeCreatingException {
        Ellipse ellipse = Ellipse.create(ellipseMajorAxis, ellipseMinorAxis);
        clientDataService.saveShape(clientId, ellipse);
    }

    @Operation(summary = "Add a new square to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The square was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })

    @PostMapping("/shape/square")
    public void postSquare(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "side") double squareSide) throws ShapeCreatingException {
        Square square = Square.create(squareSide);
        clientDataService.saveShape(clientId, square);
    }

    @ExceptionHandler(ShapeCreatingException.class)
    public ResponseEntity<ErrorMessage> handleException(ShapeCreatingException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }
}
