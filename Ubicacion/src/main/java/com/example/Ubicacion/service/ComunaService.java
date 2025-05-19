package com.example.Ubicacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ubicacion.model.Comuna;
import com.example.Ubicacion.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {
    @Autowired
    private ComunaRepository comunaRepository;

    //metodo para busacar todas las comunas
    public List<Comuna> getAllComunas() {
        return comunaRepository.findAll();
    }
    //metodo para buscar una comuna por id
    public Comuna getComunaById(Long id) {
        return comunaRepository.findById(id).orElseThrow(() -> new RuntimeException("Comuna no encontrada"));
    }
   
}
