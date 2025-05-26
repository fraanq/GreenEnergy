package com.example.Estado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Estado.model.Estado;
import com.example.Estado.service.EstadoService;

@RestController
@RequestMapping("/api/estado")

public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    // Método para obtener todos los estados
    @GetMapping("/all")
    public ResponseEntity<List<Estado>> getAllEstados() {
        List<Estado> estados = estadoService.obtenerTodosEstados();
        if (estados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estados);
    }
    // Método para obtener un estado por ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable Long id) {
        Estado estado = estadoService.obtenerEstadoById(id);
        if (estado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estado);
    }
    // Método para crear un nuevo estado
    @PostMapping("/nuevo")
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado) {
        Estado nuevoEstado = estadoService.NuevoEstado(estado);
        return ResponseEntity.ok(nuevoEstado);
    }
    // Método para actualizar un estado
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Estado> actualizarEstado(@PathVariable Long id, @RequestBody Estado estado) {
        Estado existeEstado = estadoService.obtenerEstadoById(id);
        if (existeEstado == null) {
            return ResponseEntity.notFound().build();
        }
        Estado actualizado = estadoService.actualizarEstado(id, estado);
        return ResponseEntity.ok(actualizado);
    }
    // Método para eliminar un estado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        Estado existeEstado = estadoService.obtenerEstadoById(id);
        if (existeEstado == null) {
            return ResponseEntity.notFound().build();
        }
        estadoService.eliminarEstado(id);
        return ResponseEntity.noContent().build();
    }
}
