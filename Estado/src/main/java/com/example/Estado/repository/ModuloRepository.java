package com.example.Estado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Estado.model.Modulo;

@Repository
public interface ModuloRepository  extends JpaRepository<Modulo, Long> {
    

}
