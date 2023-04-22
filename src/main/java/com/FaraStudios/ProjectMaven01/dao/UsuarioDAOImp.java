package com.FaraStudios.ProjectMaven01.dao;
import com.FaraStudios.ProjectMaven01.Models.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Component
    @Repository
    @Transactional  // funcionalidad de consulta a la base de datos
    public class  UsuarioDAOImp implements UsuarioDAO{

        @PersistenceContext
         EntityManager entityManager;

        @Override
        public List<usuario> ConseguirUsuarios() {
            String query ="FROM usuario";

           return entityManager.createQuery(query).getResultList();
        }

        @Override
        public void BorrarUsuario(long id) {
            usuario usuarioDelete = entityManager.find(usuario.class, id);
            entityManager.remove(usuarioDelete);
        }


    }
