package com.example.resena.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "resenas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resena", nullable = false, updatable = false)
    private Long idResena;

    @Column(nullable = false, length = 300)
    private String comentario;

    @Column(nullable = false)
    private int calificacion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private Long proyectoId;
}
