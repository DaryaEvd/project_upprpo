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
    const { radius, area, perimeter } = shape;
    return [
        `Radius: ${radius}`,
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}

function ellipseInfo(shape) {
    const { majorAxis, minorAxis, area, perimeter } = shape;
    return [
        `Major axis: ${majorAxis}`,
        `Minor axis: ${minorAxis}`,
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}

function squareInfo(shape) {
    const { side, area, perimeter } = shape;
    return [
        `Side: ${side}`,
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}

function rectangleInfo(shape) {
    const { side, base, area, perimeter } = shape;
    return [
        `Side: ${side}`,
        `Base: ${base}`,
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}

function parallelogramInfo(shape) {
    const { side, base, angle, area, perimeter } = shape;
    return [
        `Side: ${side}`,
        `Base: ${base}`,
        `Angle: ${angle}`,
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}

function rhombusInfo(shape) {
    const { side, angle, area, perimeter } = shape;
    return [
        `Side: ${side}`,
        `Angle: ${angle}`,
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}

function triangleInfo(shape) {
    const { firstSide, secondSide, thirdSide, area, perimeter } = shape;
    return [
        `First side: ${firstSide}`,
        `Second side: ${secondSide}`,
        `Third side: ${thirdSide}`
        `Area: ${area.toFixed(2)}`,
        `Perimeter: ${perimeter.toFixed(2)}`
    ].join('\n');
}
