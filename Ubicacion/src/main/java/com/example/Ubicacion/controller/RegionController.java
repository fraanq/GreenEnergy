package com.example.Ubicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ubicacion.model.Region;
import com.example.Ubicacion.service.RegionService;

@RestController
@RequestMapping("/api/v1/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    //metodo para buscar todas las regiones
    @GetMapping("/all")
    public ResponseEntity<List<Region>> obtenerRegiones() {
        List<Region> regiones = regionService.getAllRegiones();
        if (regiones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }

    //metodo para buscar una region por id
    @GetMapping("/id/{id}")
    public ResponseEntity<Region> obtenerRegionId(@PathVariable Long id) {
        Region region = regionService.getRegionById(id);
        if (region == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(region);
    }
}
