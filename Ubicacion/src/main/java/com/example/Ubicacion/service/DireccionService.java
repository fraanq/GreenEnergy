package com.example.Ubicacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ubicacion.model.Direccion;
import com.example.Ubicacion.repository.DireccionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    //metodo para obtener todas las direcciones
    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }
    //metodo para obtener una direccion por id
    public Direccion getDireccionById(Long id) {
        return direccionRepository.findById(id).orElseThrow(() -> new RuntimeException("Direccion no encontrada"));
    }
}
