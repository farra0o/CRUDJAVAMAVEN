package com.FaraStudios.ProjectMaven01.dao;

import com.FaraStudios.ProjectMaven01.Models.usuario;

import java.util.List;

public interface UsuarioDAO {
    List<usuario> ConseguirUsuarios();
   void BorrarUsuario(long id);

    void registrarUsuario(usuario Usuario);

    boolean VerificarPassLogin(usuario usuario);
}


