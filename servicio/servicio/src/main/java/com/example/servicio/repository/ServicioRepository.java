package com.example.servicio.repository;

import com.example.servicio.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    // Buscar servicios por ID de categoria
    List<Servicio> findByCategoriaId(Long categoriaId);
}
