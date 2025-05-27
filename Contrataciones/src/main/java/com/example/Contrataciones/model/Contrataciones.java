package com.example.Contrataciones.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contrataciones")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Contrataciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Idcontratacion;

    @Column(nullable = false, length = 50)
    private String tipoContratacion;

    @Column(nullable = false, length = 10)
    private LocalDate fechaContratacion;

    @Column(nullable = false, length = 50)
    private String estado;

    private long idusuario;
    private long iddireccion;
    private long idservicio;

}
