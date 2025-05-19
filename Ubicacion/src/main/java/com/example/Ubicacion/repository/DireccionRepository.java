package com.example.Ubicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ubicacion.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
    
}
