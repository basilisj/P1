/**
 * 
 */
 let form = document.getElementById('login').addEventListener('submit', login);
 
 async function login(e){
 e.preventDefault(); //doesn't refresh the page'
 
 let username = document.getElementById('username').value;
 let password = document.getElementById('password').value;
 console.log(username, password);
 let user = {
	username,
	password
};
console.log(user);
try{
	let req = await fetch('http://localhost:8080/P1ERS/api/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(user)
	});
	let res = await req.json();
	console.log(res);
}catch(e){
alert('Username or password was incorrect');
return;
}

location.href = 'resources/html/manager.html';
 }