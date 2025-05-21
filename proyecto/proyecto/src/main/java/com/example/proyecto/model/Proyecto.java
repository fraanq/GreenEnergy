package com.example.proyecto.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "estado_id")
    private Long estadoId;      // ID de relacion con el microservicio Estado

    @Column(name = "usuario_id")
    private Long usuarioId;     // ID del cliente desde microservicio Usuarios

    @Column(name = "servicio_id")
    private Long servicioId;    // ID del tipo de servicio

    @Column(name = "ubicacion_id")
    private Long ubicacionId;   // ID de la ubicacion
}