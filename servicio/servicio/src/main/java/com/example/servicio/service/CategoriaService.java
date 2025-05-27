package com.example.servicio.service;

import com.example.servicio.model.Servicio;
import com.example.servicio.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @PostMapping
    public ResponseEntity<Servicio> crear(@RequestBody Servicio servicio) {
        Servicio creado = servicioService.crearServicio(servicio);
        return ResponseEntity.ok(creado);
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> listarTodos() {
        return ResponseEntity.ok(servicioService.obtenerTodosLosServicios());
    }

    @GetMapping("/{idServicio}")
    public ResponseEntity<Servicio> obtenerPorId(@PathVariable Long idServicio) {
        Servicio servicio = servicioService.obtenerServicioPorId(idServicio);
        return servicio != null ? ResponseEntity.ok(servicio) : ResponseEntity.notFound().build();
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Servicio>> listarPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(servicioService.listarPorCategoria(categoriaId));
    }

    @PutMapping("/{idServicio}")
    public ResponseEntity<Servicio> actualizar(@PathVariable Long idServicio, @RequestBody Servicio servicio) {
        Servicio actualizado = servicioService.actualizarServicio(idServicio, servicio);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idServicio}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idServicio) {
        servicioService.eliminarServicio(idServicio);
        return ResponseEntity.noContent().build();
    }
}