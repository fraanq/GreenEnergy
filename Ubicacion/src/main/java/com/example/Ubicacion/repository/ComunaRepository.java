package com.example.Ubicacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ubicacion.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long> {
    

}
