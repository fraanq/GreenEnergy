package com.example.Usuarios.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Usuarios.model.Rol;
import com.example.Usuarios.model.Usuario;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Usuario> findByRolNombre(String nombreRol);
}
