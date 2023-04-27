package com.FaraStudios.ProjectMaven01.Controllers;
import com.FaraStudios.ProjectMaven01.Models.usuario;
import com.FaraStudios.ProjectMaven01.dao.UsuarioDAO;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class usuarioController {
    @Autowired
    UsuarioDAO usuarioDAO;
    private Object entityManager;

    @RequestMapping(value = "usuarios")
    public List<usuario> getUsuarios(){
    return usuarioDAO.ConseguirUsuarios();
    }

    @RequestMapping(value = "usuarios/{id}", method= RequestMethod.DELETE)
    public void deleteUsuarios( @PathVariable long id){
    usuarioDAO.BorrarUsuario(id);
    }

    @RequestMapping(value = "usuarios", method=RequestMethod.POST)
    public void crearUsuarios(@RequestBody usuario Usuario){

       // Hash de contraseña en BD
       Argon2 argon2hash = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
       String hash =argon2hash.hash(1,1024,1, Usuario.getContrasena() );
       Usuario.setContrasena(hash);

       usuarioDAO.registrarUsuario(Usuario);
    }


}
