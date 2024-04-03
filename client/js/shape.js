import { API } from './api.js';
import { drawShapes } from './draw.js';

export {
  createShape,
  getAndDrawShapes,
}

async function createShape(type) {
  if (type == 'circle') createCircle();
  else if (type == 'ellipse') createEllipse();
  else if (type == 'square') createSqure();
  else if (type == 'rectangle') createRectangle();
  else if (type == 'parallelogram') createParallelogram();
  else if (type == 'rhombus') createRhombus();
  else if (type == 'triangle') createTriangle();
}

async function createCircle() {
  const radius = prompt("Enter radius: ");
  await API.sendRequestToCreateCircle({
    radius: +radius,
  });
}

async function createEllipse() {
  const majorAxis = prompt("Enter major axis: ");
  const minorAxis = prompt("Enter minor axis: ");
  await API.sendRequestToCreateEllipse({
    major_axis: +majorAxis,
    minor_axis: +minorAxis,
  });
}

async function createSqure() {
  const squareSide = prompt("Enter side: ");
  await API.sendRequestToCreateSquare({ side: +squareSide, });
}

async function createRectangle() {
  const rectangleSide = prompt("Enter side: ");
  const rectangleBase = prompt("Enter base: ");
  await API.sendRequestToCreateRectangle({
    side: +rectangleSide,
    base: +rectangleBase,
  });
}

async function createParallelogram() {
  const parallelogramSide = prompt("Enter side: ");
  const parallelogramBase = prompt("Enter base: ");
  const parallelogramAngle = prompt("Enter angle between side and base: ");
  await API.sendRequestToCreateParallelogram({
    side: +parallelogramSide,
    base: +parallelogramBase,
    angle: +parallelogramAngle,
  });
}

async function createRhombus() {
  const rhombusSide = prompt("Enter side: ");
  const rhombusAngle = prompt("Enter angle: ");
  await API.sendRequestToCreateRhombus({
    side: +rhombusSide,
    angle: +rhombusAngle,
  });
}

async function createTriangle() {
  const firstSide = prompt("Enter first side: ");
  const secondSide = prompt("Enter second side: ");
  const thirdSide = prompt("Enter third side: ");
  await API.sendRequestToCreateTriangle({
    first_side: +firstSide,
    second_side: +secondSide,
    third_side: +thirdSide,
  });
}

async function getAndDrawShapes() {
  const shapes = await API.sendRequestToGetShapes();

  const offset = 10;
  let totalWidth = offset;
  let maxHeight = 0;
  shapes.forEach((shape) => {
    if (shape.shapeType == "CIRCLE") {
      shape.width = shape.height = shape.radius * 2;
    } else if (shape.shapeType == "ELLIPSE") {
      shape.width = shape.majorAxis * 2;
      shape.height = shape.minorAxis * 2;
    } else if (shape.shapeType == "SQUARE") {
      shape.width = shape.height = shape.side;
    } else if (shape.shapeType == "RECTANGLE") {
      shape.width = shape.base;
      shape.height = shape.side;
    } else if (shape.shapeType == "PARALLELOGRAM") {
      shape.height = shape.side * Math.abs(Math.sin(shape.angle));
      shape.width = shape.base + shape.side * Math.abs(Math.cos(shape.angle));
    } else if (shape.shapeType == "RHOMBUS") {
      shape.height = 2 * shape.side * Math.abs(Math.cos(shape.angle / 2));
      shape.width = 2 * shape.side * Math.abs(Math.sin(shape.angle / 2));
    } else if (shape.shapeType == "TRIANGLE") {
      shape.height = (2 * shape.area) / shape.thirdSide;
      shape.width = shape.thirdSide;
    }
    totalWidth += shape.width + offset;
    maxHeight = shape.height > maxHeight ? shape.height : maxHeight;
  });
  // Сортировка фигур по возрастанию вы соты
  shapes.sort((a, b) => (a.height > b.height ? 1 : -1));

  drawShapes(shapes, maxHeight, totalWidth);
}
