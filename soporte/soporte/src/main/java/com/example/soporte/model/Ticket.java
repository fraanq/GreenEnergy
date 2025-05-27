package com.example.soporte.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket", nullable = false, updatable = false)
    private Long idTicket;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(nullable = false, length = 100)
    private String domicilio;

    @Column(nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private Long servicioId;
}

