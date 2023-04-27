$(document).ready(function() {
});

async function iniciarSesion(){

  let datos ={};

  datos.correo = document.getElementById("txtCorreo").value;

  datos.contrasena = document.getElementById("txtContraseña").value;





  const Request = await fetch('usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
    const respuesta = await request.JSON
}