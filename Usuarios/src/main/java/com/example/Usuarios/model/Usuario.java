package com.example.Usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @column(name = "id")
    private Long id_user;

    @Column(lenght = 20,name = "nombre")
    private String nombre;

    @Column(lenght 20,name = "apellido")
    private String apellido;

    @Column(date ,name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(lenght = 50,name = "email")
    private String email;

    @Column(int = 10,name = "telefono")
    private int telefono;

    @Column(lenght = 50,name = "direccion")
    private String direccion;

    @column(name = clave)
    private String clave;}


}
