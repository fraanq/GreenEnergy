package com.example.soporte.controller;

import com.example.soporte.model.Estado;
import com.example.soporte.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<Estado> crear(@RequestBody Estado estado) {
        return ResponseEntity.ok(estadoService.crearEstado(estado));
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listar() {
        return ResponseEntity.ok(estadoService.listarEstados());
    }

    @GetMapping("/{idEstado}")
    public ResponseEntity<Estado> obtenerPorId(@PathVariable Long idEstado) {
        Estado estado = estadoService.obtenerPorId(idEstado);
        return estado != null ? ResponseEntity.ok(estado) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{idEstado}")
    public ResponseEntity<Estado> actualizar(@PathVariable Long idEstado, @RequestBody Estado estado) {
        Estado actualizado = estadoService.actualizar(idEstado, estado);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idEstado}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idEstado) {
        estadoService.eliminar(idEstado);
        return ResponseEntity.noContent().build();
    }
}
