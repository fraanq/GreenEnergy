package com.example.proyecto.repository;

import com.example.proyecto.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByUsuarioId(Long usuarioId);

    List<Proyecto> findByEstadoId(Long estadoId);
}
