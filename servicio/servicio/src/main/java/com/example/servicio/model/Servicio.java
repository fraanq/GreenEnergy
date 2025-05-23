package com.example.servicio.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id;

    private String nombre;

    private String descripcion;

    private Double precio;

    private String tiempo;

    @Column(name = "estado_id")
    private Long estadoId; // ID de otro microservicio

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}

