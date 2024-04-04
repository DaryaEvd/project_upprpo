import { getClientId } from './utils.js';

export const API = {
  sendRequestToGetShapes: () => {
    let clientId = getClientId();
    return fetch(`http://localhost:8080/shape/chosen/shapes_list/${clientId}`, { method: "GET", })
      .then((response) => {
        return response.json();
      })
      .catch((e) => alert("Getting error: " + e));
  },
  sendRequestToCreateCircle: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/circle?` + new URLSearchParams({
        'client_id': clientId,
        'radius': params.radius,
      }), {
        method: "POST",
      });
      alert("The circle has been successfully created!");
    } catch (e) {
      return alert(`Circle creation error: ${e}`);
    }
  },
  sendRequestToCreateEllipse: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/ellipse?` + new URLSearchParams({
        'client_id': clientId,
        'major_axis': params.major_axis,
        'minor_axis': params.minor_axis,
      }), {
        method: "POST",
      });
      alert("The ellipse has been successfully created!");
    } catch (e) {
      return alert(`Ellipse creation error: ${e}`);
    }
  },
  sendRequestToCreateSquare: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/square?` + new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
      }), {
        method: "POST",
      });
      alert("The square has been successfully created!");
    } catch (e) {
      return alert(`Square creation error: ${e}`);
    }
  },
  sendRequestToCreateRectangle: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/rectangle?` + new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
        'base': params.base,
      }), {
        method: "POST",
      });
      alert("The rectangle has been successfully created!");
    } catch (e) {
      return alert(`Rectangle creation error: ${e}`);
    }
  },
  sendRequestToCreateParallelogram: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/parallelogram?` + new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
        'base': params.base,
        'angle': params.angle,
      }), {
        method: "POST",
      });
      alert("The parallelogram has been successfully created!");
    } catch (e) {
      return alert(`Parallelogram creation error: ${e}`);
    }
  },
  sendRequestToCreateRhombus: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/rhombus?` + new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
        'angle': params.angle,
      }), {
        method: "POST",
      });
      alert("The rhombus has been successfully created!");
    } catch (e) {
      return alert(`Rhombus creation error: ${e}`);
    }
  },
  sendRequestToCreateTriangle: async (params) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/triangle?` + new URLSearchParams({
        'client_id': clientId,
        'first_side': params.first_side,
        'second_side': params.second_side,
        'third_side': params.third_side,
      }), {
        method: "POST",
      });
      alert("The triangle has been successfully created!");
    } catch (e) {
      return alert(`Triangle creation error: ${e}`);
    }
  },
  sendRequestToDeleteShape: async (shapeType) => {
    let clientId = getClientId();
    try {
      await fetch(`http://localhost:8080/shape/${shapeType}?` + new URLSearchParams({
        'client_id': clientId,
      }), {
        method: "DELETE",
      });
      alert(`The ${shapeType} has been successfully deleted!`);
    } catch (e) {
      return alert(`${shapeType} delete error: ${e}`);
    }
  },
};
