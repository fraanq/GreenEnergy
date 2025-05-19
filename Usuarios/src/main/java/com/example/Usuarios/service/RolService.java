package com.example.Usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuarios.model.Rol;
import com.example.Usuarios.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class RolService {
    @Autowired
    private RolRepository rolRepository;

    //metodo para buscar todos los roles
    public List<Rol> ObtenerTodosRol() {
        return rolRepository.findAll();
    }

    //metodo para buscar un rol por id
    public Rol BuscarRolId(Long id) {
        return rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }
    
    //metodo para crear un nuevo rol
    public void CrearRol(Rol rol) {
        rol.setNombre(rol.getNombre().toUpperCase());
        rolRepository.save(rol);
    }

    //metodo para actualizar un rol
    public void ActualizarRol(Rol rol) {
        rolRepository.save(rol);
    }

    //metodo para eliminar un rol
    public void EliminarRol(Long id) {
        rolRepository.deleteById(id);
    }

}
