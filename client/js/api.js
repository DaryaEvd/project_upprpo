import { getClientId } from "./utils.js";

export function getRequest(path) {
  const clientId = getClientId();
  const response = fetch(`http://109.71.242.166:8080/shape/${path}/${clientId}`, { method: "GET", })
    .then((response) => response.json())
    .catch((e) => alert("Getting error: " + e));
  if (!response) {
    throw new Error();
  }
  return response;
}

export async function postRequest(path, queryParams) {
  const searchParams = new URLSearchParams(queryParams);
  searchParams.append('client_id', getClientId());
  const response = await fetch(
    `http://109.71.242.166:8080/shape/${path}?` + searchParams,
    { method: "POST" }
  ).catch((e) => alert(`Error: ${e.message}`));
  if (!response) {
    throw new Error();
  }
  if (!response.ok) {
    const data = await response.json();
    alert(data.message);
    throw new Error(data.message);
  }
  return response;
}

export async function deleteRequest(path) {
  const params = new URLSearchParams({'client_id': getClientId()})
  // await fetch(`http://109.71.242.166:8080/shape/${path}?` + params, { method: "DELETE", })
  await fetch(`http://localhost:8080/shape/${path}?` + params, { method: "DELETE", })
    .catch((e) => alert("Getting error: " + e));
}