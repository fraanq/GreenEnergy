package com.example.Usuario.repository;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Usuario.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}