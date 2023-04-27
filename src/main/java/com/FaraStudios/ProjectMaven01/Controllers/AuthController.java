package com.FaraStudios.ProjectMaven01.Controllers;
import com.FaraStudios.ProjectMaven01.Models.usuario;
import com.FaraStudios.ProjectMaven01.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    UsuarioDAO usuarioDAO;

    @RequestMapping(value = "login", method= RequestMethod.POST)
    public String login(@RequestBody usuario Usuario){
        if (usuarioDAO.VerificarPassLogin(Usuario)){
            return "OK";
        }
        return "Error de Credenciales";
    }

}
