
export function drawShapes(shapes, maxH, totalW) {
    const canvas = document.getElementById("canvas");
    if (canvas.getContext) {
        const context = canvas.getContext("2d");
        
        context.clearRect(0, 0, canvas.width, canvas.height);
        
        const offset = 10;
        canvas.setAttribute('width', totalW);
        canvas.setAttribute('height', maxH + offset);

        context.beginPath();

        const y = 5;
        let x = 5;

        shapes.forEach((shape) => {
            drawShape(context, shape, x, y);
            x += shape.width + offset;
        });
    }
}

function drawShape(context, shape, x, y) {
    const hj = {
        CIRCLE: drawCircle,
        ELLIPSE: drawEllipse,
        SQUARE: drawSquare,
        RECTANGLE: drawRectangle,
        PARALLELOGRAM: drawParallelogram,
        RHOMBUS: drawRhombus,
        TRIANGLE: drawTriangle,
    };
    hj[shape.shapeType](context, shape, x, y);
}

function drawCircle(context, shape, x, y) {
    context.beginPath();
    context.strokeStyle = "rgb(0, 128, 0)";
    context.fillStyle = "rgba(50, 145, 50, 0.7)";
    context.arc(x + shape.radius, y + shape.radius, shape.radius, 0, Math.PI * 2, true);
    context.stroke();
    context.fill();
    context.closePath();
}

function drawEllipse(context, shape, x, y) {
    context.beginPath();
    context.strokeStyle = "yellow";
    context.fillStyle = "rgba(220, 220, 80, 0.7)";
    // TODO что с линией в moveTo
    context.moveTo(x + shape.majorAxis, y + shape.minorAxis * 2 - 3);
    context.ellipse(x + shape.majorAxis, y + shape.minorAxis, shape.minorAxis, shape.majorAxis, Math.PI / 2, 0, 2 * Math.PI);
    context.stroke();
    context.fill();
    context.closePath();
}

function drawSquare(context, shape, x, y) {
    context.beginPath();
    context.strokeStyle = "red";
    context.fillStyle = "rgba(180, 80, 80, 0.7)";
    context.strokeRect(x, y, shape.side, shape.side);
    context.fillRect(x, y, shape.side, shape.side);
    context.closePath();
}

function drawRectangle(context, shape, x, y) {
    context.beginPath();
    context.strokeStyle = "blue";
    context.fillStyle = "rgba(70, 70, 180, 0.7)";
    context.strokeRect(x, y, shape.base, shape.side);
    context.fillRect(x, y, shape.base, shape.side);
    context.closePath();
}

function drawParallelogram(context, shape, x, y) {
    let shift = shape.side * Math.abs(Math.cos(shape.angle));

    context.beginPath();
    context.strokeStyle = "orange";
    context.fillStyle = "rgba(225, 170, 70, 0.7)";
    context.moveTo(x + shift, y);
    context.lineTo(x + shift + shape.base, y);
    context.lineTo(x + shape.base, y + shape.height);
    context.lineTo(x, y + shape.height);
    context.lineTo(x + shift, y);
    context.stroke();
    context.fill();
    context.closePath();
}

function drawRhombus(context, shape, x, y) {
    let xShift = shape.side * Math.abs(Math.sin(shape.angle / 2));
    let yShift = shape.side * Math.abs(Math.cos(shape.angle / 2));
    let newX = x + (shape.width / 2);

    context.beginPath();
    context.strokeStyle = "lightblue";
    context.fillStyle = "rgba(185, 210, 220, 0.7)";
    context.moveTo(newX, y);
    context.lineTo(newX + xShift, y + yShift);
    context.lineTo(newX, y + 2 * yShift);
    context.lineTo(newX - xShift, y + yShift);
    context.lineTo(newX, y);
    context.stroke();
    context.fill();
    context.closePath();
}

function drawTriangle(context, shape, x, y) {
    const shift = Math.sqrt(Math.pow(shape.firstSide, 2) - Math.pow(shape.height, 2));

    context.beginPath();
    context.strokeStyle = "violet";
    context.fillStyle = "rgba(220, 150, 220, 0.7)";
    context.moveTo(x + shift, y);
    context.lineTo(x + shape.thirdSide, y + shape.height);
    context.lineTo(x, y + shape.height);
    context.lineTo(x + shift, y);
    context.stroke();
    context.fill();
    context.closePath();
}