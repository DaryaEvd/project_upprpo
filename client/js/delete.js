import { API } from './api.js';

export async function addEventDelete(wrapper,  elem, shapeType) {
    elem.addEventListener('click', function () {
        API.sendRequestToDeleteShape(shapeType);
        wrapper.removeChild(elem);
    })
};