import { getClientId } from './utils.js';
import { getRequest, postRequest, deleteRequest } from './api.js';

export const API = {
  sendRequestToGetShapes: () => {
    const clientId = getClientId();
    return getRequest(`chosen/shapes_list/${clientId}`);
  },
  sendRequestToGetShapesName: () => {
    const clientId = getClientId();
    return getRequest(`chosen/names_list/${clientId}`);
  },
  sendRequestToCreateCircle: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('circle?', new URLSearchParams({ 'client_id': clientId, 'radius': params.radius, }),)
      alert("The circle has been successfully created!");
    } catch (e) {
      return alert(`Circle creation error: ${e}`);
    }
  },
  sendRequestToCreateEllipse: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('ellipse?', new URLSearchParams({ 'client_id': clientId, 'major_axis': params.major_axis, 'minor_axis': params.minor_axis, }));
      alert("The ellipse has been successfully created!");
    } catch (e) {
      return alert(`Ellipse creation error: ${e}`);
    }
  },
  sendRequestToCreateSquare: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('square?', new URLSearchParams({ 'client_id': clientId, 'side': params.side, }));
      alert("The square has been successfully created!");
    } catch (e) {
      return alert(`Square creation error: ${e}`);
    }
  },
  sendRequestToCreateRectangle: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('rectangle?', new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
        'base': params.base,
      }))
      alert("The rectangle has been successfully created!");
    } catch (e) {
      return alert(`Rectangle creation error: ${e}`);
    }
  },
  sendRequestToCreateParallelogram: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('parallelogram?', new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
        'base': params.base,
        'angle': params.angle,
      }));
      alert("The parallelogram has been successfully created!");
    } catch (e) {
      return alert(`Parallelogram creation error: ${e}`);
    }
  },
  sendRequestToCreateRhombus: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('rhombus?', new URLSearchParams({
        'client_id': clientId,
        'side': params.side,
        'angle': params.angle,
      }));
      alert("The rhombus has been successfully created!");
    } catch (e) {
      return alert(`Rhombus creation error: ${e}`);
    }
  },
  sendRequestToCreateTriangle: async (params) => {
    const clientId = getClientId();
    try {
      postRequest('triangle?', new URLSearchParams({
        'client_id': clientId,
        'first_side': params.first_side,
        'second_side': params.second_side,
        'third_side': params.third_side,
      }));
      alert("The triangle has been successfully created!");
    } catch (e) {
      return alert(`Triangle creation error: ${e}`);
    }
  },
  sendRequestToDeleteShape: async (shapeType) => {
    const clientId = getClientId();
    try {
      deleteRequest(shapeType, new URLSearchParams({'client_id': clientId,}));
      alert(`The ${shapeType} has been successfully deleted!`);
    } catch (e) {
      alert(`${shapeType} delete error: ${e}`);
      throw e;
    }
  },
};
