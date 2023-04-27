// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#Usuarios').DataTable();
});


async function cargarUsuarios(){

  const Request = await fetch('usuarios', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const usuarios = await Request.json();

  let usuariosList= "";
  for ( usuario of usuarios){
  let BotonBorrar= '<a href="#" onClick="borrarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'
  let usuarioHTML = '<tr><td>' +usuario.id+
                    '</td><td>'+ usuario.nombre+
                    '</td><td>'+ usuario.apellido+
                    '</td><td>'+usuario.correo+
                    '<td>'+ usuario.telefono +
                     '<td>'+ usuario.contrasena +
                    '</td><td>'+ BotonBorrar +'</td></tr>';

  usuariosList+= usuarioHTML;
}

  console.log(usuarios);
  document.querySelector('#Usuarios tbody').outerHTML =usuariosList;
}

async function borrarUsuario(id){

if (!confirm("Desea eliminar Usuario")){
  location.reload();
  return;
}

const Request = await fetch('usuarios/' +id, {
  method: 'DELETE',
  headers: {
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
});
  location.reload()
}