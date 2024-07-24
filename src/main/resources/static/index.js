document.getElementById('loginForm').addEventListener('submit', function (event) {
	event.preventDefault(); // Evita que el formulario se envíe de la manera tradicional

	const username = document.getElementById('username').value;
	const password = document.getElementById('password').value;
	
	//Variable tipo objeto
	const credenciales = { 
		usuario: username,
		clave: password
	};
	//consumo API POST
	fetch('http://localhost:8080/v1', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		//Convierte el objeto a JSON
		body: JSON.stringify(credenciales)
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok ' + response.statusText);
			}
			return response.json(); 
		})
		.then(data => {
			if(data == 0){
				document.getElementById('responseData').innerText = 'Usuario y/o contraseña incorrecto ';
			}else{				
				document.getElementById('responseData').innerText = 'Ingreso exitoso';
			}
		})
		.catch(error => {
			console.error('There was a problem with your fetch operation:', error);
		});
});
