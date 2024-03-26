package ru.nsu.fit.capibaras;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.fit.capibaras.shapes.*;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/shape/list")
    public List<Shape> getShapeLists() {
        return null;
    }

    @GetMapping("/shape/rectangle")
    public Rectangle getRectangle(@RequestParam(value = "side") double rectangleSide,
                                    @RequestParam(value = "base") double rectangleBase) {
        System.out.println(rectangleBase);
        System.out.println(rectangleSide);
        return new Rectangle(rectangleBase, rectangleSide);
    }

    @PostMapping("/shape/triangle")
    public Shape getTriangle(@RequestParam(value = "first_side") double triangleFirstSide,
                                   @RequestParam(value = "second_side") double triangleSecondSide,
                                   @RequestParam(value = "third_side") double triangleThirdSide) throws ShapeCreatingException {
        return Triangle.create(triangleFirstSide, triangleSecondSide, triangleThirdSide);
    }

    @GetMapping("/shape/parallelogram")
    public Shape getParallelogram(@RequestParam(value = "side") double parallelogramSide,
                                    @RequestParam(value = "base") double parallelogramBase,
                                    @RequestParam(value = "angle") double parallelogramAngle) {
        return new Parallelogram(parallelogramBase, parallelogramSide, parallelogramAngle);
    }

    @GetMapping("/shape/rhombus")
    public Shape getRhombus(@RequestParam(value = "side") double rhombusSide,
                                        @RequestParam(value = "angle") double rhombusAngle) {
        return new Rhombus(rhombusSide, rhombusAngle);
    }

    @GetMapping("/shape/circle")
    public Shape getCircle(@RequestParam(value = "radius") double circleRadius) {
        return new Circle(circleRadius);
    }

    @GetMapping("/shape/ellipse")
    public Shape getEllipse(@RequestParam(value = "major_axis") double ellipseMajorAxis,
                                  @RequestParam(value = "minor_axis") double ellipseMinorAxis) {
        return new Ellipse(ellipseMajorAxis, ellipseMinorAxis);
    }

    @GetMapping("/shape/square")
    public Shape getSquare(@RequestParam(value = "side") double squareSide) {
        return new Square(squareSide);
    }

}