package com.FaraStudios.ProjectMaven01.Models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class usuario {

    @Id
    @Getter @Setter
    @Column(name = "id",unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter  @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "correo")
    private String correo;

    @Getter @Setter @Column(name = "telefono")
    private String telefono;

    @Getter @Setter @Column(name = "contraseña")
    private String contrasena;

}


