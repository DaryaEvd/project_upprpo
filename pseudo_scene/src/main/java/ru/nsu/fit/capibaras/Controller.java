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

@CrossOrigin(origins = "http://109.71.242.166")
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
                              @RequestParam(value = "side") String rectangleSide,
                              @RequestParam(value = "base") String rectangleBase) throws ShapeCreatingException {
        try {
            double base = Double.parseDouble(rectangleBase);
            double side = Double.parseDouble(rectangleSide);
            Rectangle rectangle = Rectangle.create(base, side);
            clientDataService.saveShape(clientId, rectangle);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
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
                             @RequestParam(value = "first_side") String triangleFirstSide,
                             @RequestParam(value = "second_side") String triangleSecondSide,
                             @RequestParam(value = "third_side") String triangleThirdSide)
            throws ShapeCreatingException {
        try {
            double firstSide = Double.parseDouble(triangleFirstSide);
            double secondSide = Double.parseDouble(triangleSecondSide);
            double thirdSide = Double.parseDouble(triangleThirdSide);
            Triangle triangle = Triangle.create(firstSide, secondSide, thirdSide);
            clientDataService.saveShape(clientId, triangle);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
    }

    @Operation(summary = "Add a new parallelogram to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The parallelogram was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/parallelogram")
    public void postParallelogram(@RequestParam(value = "client_id") String clientId,
                                  @RequestParam(value = "side") String parallelogramSide,
                                  @RequestParam(value = "base") String parallelogramBase,
                                  @RequestParam(value = "angle") String parallelogramAngle)
            throws ShapeCreatingException {
        try {
            double base = Double.parseDouble(parallelogramBase);
            double side = Double.parseDouble(parallelogramSide);
            double angle = Double.parseDouble(parallelogramAngle);
            Parallelogram parallelogram = Parallelogram.create(base, side, angle);
            clientDataService.saveShape(clientId, parallelogram);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
    }

    @Operation(summary = "Add a new rhombus to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The rhombus was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/rhombus")
    public void postRhombus(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "side") String rhombusSide,
                            @RequestParam(value = "angle") String rhombusAngle) throws ShapeCreatingException {
        try {
            double side = Double.parseDouble(rhombusSide);
            double angle = Double.parseDouble(rhombusAngle);
            Rhombus rhombus = Rhombus.create(side, angle);
            clientDataService.saveShape(clientId, rhombus);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
    }

    @Operation(summary = "Add a new circle to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The circle was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/circle")
    public void postCircle(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "radius") String circleRadius) throws ShapeCreatingException {
        try {
            double radius = Double.parseDouble(circleRadius);
            Circle circle = Circle.create(radius);
            clientDataService.saveShape(clientId, circle);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
    }

    @Operation(summary = "Add a new ellipse to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The ellipse was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })
    @PostMapping("/shape/ellipse")
    public void postEllipse(@RequestParam(value = "client_id") String clientId,
                            @RequestParam(value = "major_axis") String ellipseMajorAxis,
                            @RequestParam(value = "minor_axis") String ellipseMinorAxis) throws ShapeCreatingException {
        try {
            double majorAxis = Double.parseDouble(ellipseMajorAxis);
            double minorAxis = Double.parseDouble(ellipseMinorAxis);
            Ellipse ellipse = Ellipse.create(majorAxis, minorAxis);
            clientDataService.saveShape(clientId, ellipse);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
    }

    @Operation(summary = "Add a new square to the set ones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "The square was successfully added"),
            @ApiResponse(responseCode = "400", description = "Negative parameters were entered")
    })

    @PostMapping("/shape/square")
    public void postSquare(@RequestParam(value = "client_id") String clientId,
                           @RequestParam(value = "side") String squareSide) throws ShapeCreatingException {
        try {
            double side = Double.parseDouble(squareSide);
            Square square = Square.create(side);
            clientDataService.saveShape(clientId, square);
        } catch (NumberFormatException e) {
            throw ShapeCreatingException.nonNumericParameterValue();
        }
    }

    @ExceptionHandler(ShapeCreatingException.class)
    public ResponseEntity<ErrorMessage> handleException(ShapeCreatingException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }
}
