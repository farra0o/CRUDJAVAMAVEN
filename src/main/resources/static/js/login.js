$(document).ready(function() {
});

async function iniciarSesion(){

  let datos ={};

  datos.correo = document.getElementById("txtCorreo").value;

  datos.contrasena = document.getElementById("txtContraseña").value;

  const Request = await fetch('login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  
  const respuesta = await requestAnimationFrame.text();
  if (respuesta != 'FAIL'){
    localStorage.token = respuesta;
    localStorage.email = datos.correo;
    windows.location.href= "usuarios.html"

  } else {
    alert (" Las credenciales son Incorrectas por favor intente de nuevo")
  }
}