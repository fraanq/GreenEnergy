package com.example.Estado.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "privilegios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Privilegios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id")
    private Modulo modulo;

    @ManyToOne
    @JoinColumn(name = "id")
    private Estado estado;


}
