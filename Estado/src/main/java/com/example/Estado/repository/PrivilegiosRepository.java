package com.example.Estado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Estado.model.Privilegios;

@Repository
public interface PrivilegiosRepository extends JpaRepository<Privilegios, Long> {
    

}
