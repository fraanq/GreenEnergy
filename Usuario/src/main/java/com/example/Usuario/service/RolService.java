package com.example.Usuario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuario.model.Rol;
import com.example.Usuario.repository.RolRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //metodo para buscar todos los roles
    public List<Rol> ObtenerTodosRol() {
        return rolRepository.findAll();
    }

    //metodo para buscar un rol por id
    public Rol BuscarRolId(Long id) {
        return rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }
    
    //metodo para crear un nuevo rol
    public Rol CrearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    //metodo para actualizar un rol
    public Rol ActualizarRol(Rol rol) {
        Rol rolExistente = rolRepository.findById(rol.getIdrol()).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rolExistente.setNombre(rol.getNombre());
        return rolRepository.save(rolExistente);
    }

    //metodo para eliminar un rol
    public void eliminarRol(Long id) {
        Rol rol = rolRepository.findById(id).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        rolRepository.delete(rol);
    }

}