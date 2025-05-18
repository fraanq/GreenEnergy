package com.example.Usuarios.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Usuarios.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
