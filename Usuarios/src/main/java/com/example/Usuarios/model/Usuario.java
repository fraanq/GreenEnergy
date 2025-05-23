package com.example.Usuarios.model;

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
    private Long id_user;

    @Column(nullable = false,length = 12)
    private String rut;   

    @Column(nullable = false,length = 20)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String apellido;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(nullable = false, length = 9)
    private int telefono;

    @Column(nullable = false, length = 20)
    private String contraseña;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_rol")
    private Rol rol;
    
    
}
