import { API } from './api.js';
import { drawShapes } from './draw.js';
import { addEventDelete } from './delete.js'
import { addShapeInfo } from './info.js';

export {
  createShape,
  getAndDrawShapes,
  displayListOfShapesToDelete,
  displayListOfShapesWithParams,
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
  // Сортировка фигур по возрастанию высоты
  shapes.sort((a, b) => (a.height > b.height ? 1 : -1));

  drawShapes(shapes, maxHeight, totalWidth);

  displayListOfShapesWithParams(shapes);
}

async function displayListOfShapesToDelete() {
  const shapes = await API.sendRequestToGetShapesName();
  const wrapper = document.querySelector('#wrapper');
  const backButton = wrapper.querySelector('#back');

  shapes.forEach((shape) => {
    outputShape(shape, wrapper, backButton);
  });
}

async function outputShape(shape, wrapper, backButton) {
  let button = document.createElement('button');
  button.setAttribute('class', 'd-block w-75 floating-button button-text b-none');
  button.textContent = `${shape}`;
  addEventDelete(wrapper, button, shape);

  wrapper.insertBefore(button, backButton);
}

async function displayListOfShapesWithParams(shapes) {
  const wrapper = document.querySelector('#wrapper');

  shapes.forEach((shape, i) => {
    displayShapeWithParams(shape, wrapper, i);
  });
}

async function displayShapeWithParams(shape, wrapper, i) {
  let button = createButton(i);

  button.addEventListener('click', function () {
    let info = document.getElementById(`info${i}`);
    if (info) {
      wrapper.removeChild(info);
    } else {
      info = addShapeInfo(shape, i);
      const nextButton = document.getElementById(`button${i + 1}`);
      wrapper.insertBefore(info, nextButton);
    }
  });

  button.textContent = `${shape.shapeType}`;
  wrapper.appendChild(button);
}

function createButton(i) {
  let button = document.createElement('button');
  button.setAttribute('class', 'd-block w-75 floating-button button-text b-none');
  button.setAttribute('id', `button${i}`);
  return button;
}
