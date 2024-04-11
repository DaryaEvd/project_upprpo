import { API } from './apiShape.js';
import { drawShapes } from './draw.js';
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
  if (isCorrect(radius)) {
    await API.sendRequestToCreateCircle({
      radius: +radius,
    });
  }
}

async function createEllipse() {
  const majorAxis = prompt("Enter major axis: ");
  const minorAxis = prompt("Enter minor axis: ");
  if (isCorrect(majorAxis, minorAxis)) {
    await API.sendRequestToCreateEllipse({
      major_axis: +majorAxis,
      minor_axis: +minorAxis,
    });
  }
}

async function createSqure() {
  const squareSide = prompt("Enter side: ");
  if (isCorrect(squareSide)) {
    await API.sendRequestToCreateSquare({ side: +squareSide, });
  }
}

async function createRectangle() {
  const rectangleSide = prompt("Enter side: ");
  const rectangleBase = prompt("Enter base: ");
  if (isCorrect(rectangleSide, rectangleBase)) {
    await API.sendRequestToCreateRectangle({
      side: +rectangleSide,
      base: +rectangleBase,
    });
  }
}

async function createParallelogram() {
  const parallelogramSide = prompt("Enter side: ");
  const parallelogramBase = prompt("Enter base: ");
  const parallelogramAngle = prompt("Enter angle between side and base: ");
  if (isCorrect(parallelogramSide, parallelogramBase, parallelogramAngle)) {
    await API.sendRequestToCreateParallelogram({
      side: +parallelogramSide,
      base: +parallelogramBase,
      angle: +parallelogramAngle,
    });
  }
}

async function createRhombus() {
  const rhombusSide = prompt("Enter side: ");
  const rhombusAngle = prompt("Enter angle: ");
  if (isCorrect(rhombusSide, rhombusAngle)) {
    await API.sendRequestToCreateRhombus({
      side: +rhombusSide,
      angle: +rhombusAngle,
    });
  }
}

async function createTriangle() {
  const firstSide = prompt("Enter first side: ");
  const secondSide = prompt("Enter second side: ");
  const thirdSide = prompt("Enter third side: ");
  if (isCorrect(firstSide, secondSide, thirdSide)) {
    await API.sendRequestToCreateTriangle({
      first_side: +firstSide,
      second_side: +secondSide,
      third_side: +thirdSide,
    });
  }
}

function isCorrect(...args) {
  for (let arg of args) {
    if (isNaN(arg) || arg === '' || arg === null) {
      alert('Enter the correct number');
      return 0;
    }
  }
  return 1;
}

async function getAndDrawShapes(canvasId, wrapperId) {
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

  drawShapes(canvasId, shapes, maxHeight, totalWidth);

  displayListOfShapesWithParams(wrapperId, shapes);
}

async function displayListOfShapesToDelete(wrapperId, backButtonId) {
  const shapes = await API.sendRequestToGetShapesName();
  const wrapper = document.getElementById(wrapperId);
  const backButton = document.getElementById(backButtonId);

  shapes.forEach((shape) => {
    outputShape(shape, wrapper, backButton);
  });
}

async function outputShape(shape, wrapper, backButton) {
  let button = document.createElement('button');
  button.setAttribute('class', 'd-block w-75 floating-button button-text b-none');
  button.textContent = `${shape}`;
  button.addEventListener('click', async function () {
    await API.sendRequestToDeleteShape(shape);
    wrapper.removeChild(button);
  })

  wrapper.insertBefore(button, backButton);
}

async function displayListOfShapesWithParams(wrapperId, shapes) {
  const wrapper = document.getElementById(wrapperId);

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
