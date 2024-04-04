export function addShapeInfo(shape, i) {
    let info = document.createElement('p');
    info.setAttribute('class', 'd-flex justify-content-center');
    info.setAttribute('style', 'white-space: pre-wrap;');
    info.setAttribute('id', `info${i}`);
    info.textContent = shapeInfo(shape);
    return info;
}

function shapeInfo(shape) {
    if (shape.shapeType == 'CIRCLE') return circleInfo(shape);
    else if (shape.shapeType == 'ELLIPSE') return ellipseInfo(shape);
    else if (shape.shapeType == 'SQUARE') return squareInfo(shape);
    else if (shape.shapeType == 'RECTANGLE') return rectangleInfo(shape);
    else if (shape.shapeType == 'PARALLELOGRAM') return parallelogramInfo(shape);
    else if (shape.shapeType == 'RHOMBUS') return rhombusInfo(shape);
    else if (shape.shapeType == 'TRIANGLE') return triangleInfo(shape);
}

function circleInfo(shape) {
    return `Radius: ${shape.radius}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}

function ellipseInfo(shape) {
    return `Major axis: ${shape.majorAxis}\nMinor axis: ${shape.minorAxis}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}

function squareInfo(shape) {
    return `Side: ${shape.side}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}

function rectangleInfo(shape) {
    return `Side: ${shape.side}\nBase: ${shape.base}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}

function parallelogramInfo(shape) {
    return `Side: ${shape.side}\nBase: ${shape.base}\nAngle: ${shape.angle}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}

function rhombusInfo(shape) {
    return `Side: ${shape.side}\nAngle: ${shape.angle}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}

function triangleInfo(shape) {
    return `First side: ${shape.firstSide}\nSecond side: ${shape.secondSide}\nThird side: ${shape.thirdSide}\nArea: ${shape.area.toFixed(2)}\nPerimeter: ${shape.perimeter.toFixed(2)}`;
}
