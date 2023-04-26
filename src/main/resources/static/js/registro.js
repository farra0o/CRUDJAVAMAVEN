$(document).ready(function() {

});

async function crearUsuarios(){
  let datos ={};
  datos.nombre = document.getElementById("txtNombre").value;
  datos.apellido = document.getElementById("txtApellido").value;
  datos.correo = document.getElementById("txtCorreo").value;
  datos.telefono = document.getElementById("txtTelefono").value;
  datos.contrasena = document.getElementById("txtContraseña").value;
  const Request = await fetch('usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)

  });
  const usuarios = await Request.json();

}