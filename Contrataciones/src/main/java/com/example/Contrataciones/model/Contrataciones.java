package com.example.Contrataciones.model;

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
    @Column(name = "id_contratacion")
    private String id;

    @Column(name = "Tipo_contratacion")
    private String tipoContratacion;

    @Column(name = "fecha_contratacion")
    private String fechaContratacion;

    @Column(name = "Estado")
    private String estado;

    private long usuarioId;
    private long direccionId;
    private long servicioId;

}
