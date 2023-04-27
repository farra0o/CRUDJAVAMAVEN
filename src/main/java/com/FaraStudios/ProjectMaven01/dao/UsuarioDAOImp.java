package com.FaraStudios.ProjectMaven01.dao;
import com.FaraStudios.ProjectMaven01.Models.usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

        @Override
        public void registrarUsuario(usuario Usuario) {
            entityManager.merge(Usuario);
        }

        @Override
        public boolean VerificarPassLogin(usuario usuario) {

            String query ="FROM usuario where correo= :correo ";
            List<usuario> lista= entityManager.createQuery(query)
                               .setParameter("correo", usuario.getCorreo())
                               .getResultList();

            if (lista.isEmpty()){
                return  false;
            }

            String passwordHashed = lista.get(0).getContrasena();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            return argon2.verify(passwordHashed, usuario.getContrasena());
        }


    }
