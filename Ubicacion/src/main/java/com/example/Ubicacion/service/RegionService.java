package com.example.Ubicacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ubicacion.model.Region;
import com.example.Ubicacion.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    //metodo para obtener todas las regiones
    public List<Region> getAllRegiones() {
        return regionRepository.findAll();
    }
    //metodo para obtener una region por id
    public Region getRegionById(Long id) {
        return regionRepository.findById(id).orElseThrow(() -> new RuntimeException("Region no encontrada"));
    }
}
