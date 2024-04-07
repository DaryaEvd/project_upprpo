import { API } from './api.js';

export function addEventDelete(wrapper,  elem, shapeType) {
    elem.addEventListener('click', async function () {
        await API.sendRequestToDeleteShape(shapeType);
        wrapper.removeChild(elem);
    })
};