package com.example.Usuarios.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long id_user;

    @Column(length = 20,name = "nombre")
    private String nombre;

    @Column(length = 20,name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;

    @Column(length = 50,name = "email")
    private String email;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "clave")
    private String clave;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
    
    
}
