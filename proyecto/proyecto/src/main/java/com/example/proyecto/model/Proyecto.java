package com.example.proyecto.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "proyecto")
@AllArgsConstructor
@NoArgsConstructor


public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_proyecto")
    private Long idProyecto;

    @Column(name = "id_contrato")
    private Long idContrato;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_estado")
    private Long idEstado;




}
