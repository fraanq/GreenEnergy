package com.example.proyecto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.proyecto.model.Proyecto;

@Repository
public interface ProyectoRpository extends JpaRepository<Proyecto, Long> {
    List<Proyecto> findfindByIdUsuario(Long idusuario);
}
