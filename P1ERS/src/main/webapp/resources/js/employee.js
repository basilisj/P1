"use strict";

const errorElement = document.getElementById("error");
let submitButton = document.getElementById("login");
let username = document.getElementById("username");
let password = document.getElementById("password");
let form = document.querySelector("form");

async function login() {
  let data = {
    username: username.value,
    password: password.value,
  };

  console.log(data);

  const result = await fetch("http://localhost:8080/api/reimbursement", {
    method: "POST",
    mode: "no-cors",
    credentials: "include",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  }).then(response => {
    if (response.status === 200){
      return response;
    } else if (response.status === 401) {
      displayInvalidLogin();
    }
  })

  const myData = await result.json();

  if(myData.roleId === 1) {
    window.location.href = "./manager.html";
  } else if(myData.roleId === 2) {
    window.location.href = "./employee.html";
  }

}

function displayInvalidLogin() {
  let pElement = document.querySelector("#invalid-login");
  pElement.style.color = "hsl(0, 100%, 68%);";
  pElement.innerHTML = "Invalid Login. Please try again.";
}

submitButton.addEventListener("click", login);
