export async function getRequest(path) {
  return fetch(`http://109.71.242.166:8080/shape/${path}`, { method: "GET", })
    .then((response) => {
      return response.json();
    })
    .catch((e) => alert("Getting error: " + e));
}

export async function postRequest(path, params) {
  await fetch(`http://109.71.242.166:8080/shape/${path}` + params, {
    method: "POST",
  });
}

export async function deleteRequest(path, params) {
  await fetch(`http://109.71.242.166:8080/shape/${path}?` + params, { method: "DELETE", });
}