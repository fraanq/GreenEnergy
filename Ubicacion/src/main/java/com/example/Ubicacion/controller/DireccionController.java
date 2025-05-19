package com.example.Ubicacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ubicacion.model.Direccion;
import com.example.Ubicacion.service.DireccionService;



@RestController
@RequestMapping("/api/v1/direccion")
public class DireccionController {  
    @Autowired
    private DireccionService direccionService;

    //metodo para buscar todas las direcciones
    @GetMapping("/all")
    public ResponseEntity<List<Direccion>> obtenerDirecciones() {
        List<Direccion> direcciones = direccionService.getAllDirecciones();
        if (direcciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(direcciones);
    }

    //metodo para buscar una direccion por id
    @GetMapping("/id/{id}")
    public ResponseEntity<Direccion> obtenerDireccionId(@PathVariable Long id) {
        Direccion direccion = direccionService.getDireccionById(id);
        if (direccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(direccion);
    }

}
