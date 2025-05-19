package com.example.Ubicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ubicacion.model.Comuna;
import com.example.Ubicacion.service.ComunaService;

@RestController
@RequestMapping("/api/v1/comuna")
public class ComunaController {
    @Autowired
    private ComunaService comunaService;

    //metodo para buscar todas las comunas
    @GetMapping("/all")
    public ResponseEntity<List<Comuna>> obtenerComunas() {
        List<Comuna> comunas = comunaService.getAllComunas();
        if (comunas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comunas);
    }
    //metodo para buscar una comuna por id
    @GetMapping("/id/{id}")
    public ResponseEntity<Comuna> obtenerComunaId(@PathVariable Long id) {
        Comuna comuna = comunaService.getComunaById(id);
        if (comuna == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comuna);
    }
}
