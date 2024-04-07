import { getRequest, postRequest, deleteRequest } from './api.js';

export const API = {
  sendRequestToGetShapes: () => {
    return getRequest(`chosen/shapes_list`);
  },
  sendRequestToGetShapesName: () => {
    return getRequest(`chosen/names_list`);
  },
  sendRequestToCreateCircle: async (params) => {
    await postRequest('circle', params)
    alert("The circle has been successfully created!");
  },
  sendRequestToCreateEllipse: async (params) => {
    await postRequest('ellipse', {
      'major_axis': params.major_axis,
      'minor_axis': params.minor_axis,
    });
    alert("The ellipse has been successfully created!");
  },
  sendRequestToCreateSquare: async (params) => {
    await postRequest('square', { 'side': params.side, });
    alert("The square has been successfully created!");
  },
  sendRequestToCreateRectangle: async (params) => {
    await postRequest('rectangle', {
      'side': params.side,
      'base': params.base,
    })
    alert("The rectangle has been successfully created!");
  },
  sendRequestToCreateParallelogram: async (params) => {
    await postRequest('parallelogram', {
      'side': params.side,
      'base': params.base,
      'angle': params.angle,
    });
    alert("The parallelogram has been successfully created!");
  },
  sendRequestToCreateRhombus: async (params) => {
    await postRequest('rhombus', {
      'side': params.side,
      'angle': params.angle,
    });
    alert("The rhombus has been successfully created!");
  },
  sendRequestToCreateTriangle: async (params) => {
    await postRequest('triangle', {
      'first_side': params.first_side,
      'second_side': params.second_side,
      'third_side': params.third_side,
    });
    alert("The triangle has been successfully created!");
  },
  sendRequestToDeleteShape: async (shapeType) => {
    await deleteRequest(shapeType);
    alert(`The ${shapeType} has been successfully deleted!`);
  },
};
