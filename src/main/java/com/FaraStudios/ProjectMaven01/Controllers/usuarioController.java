package com.FaraStudios.ProjectMaven01.Controllers;
import com.FaraStudios.ProjectMaven01.Models.usuario;
import com.FaraStudios.ProjectMaven01.dao.UsuarioDAO;
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
       usuarioDAO.registrarUsuario(Usuario);
    }

}
