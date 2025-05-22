package com.example.proyecto.controller;

import com.example.proyecto.model.Proyecto;
import com.example.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto creado = proyectoService.crearProyecto(proyecto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Proyecto>> listarTodos() {
        List<Proyecto> proyectos = proyectoService.listarProyectos();
        return ResponseEntity.ok(proyectos);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Proyecto>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Proyecto> proyectos = proyectoService.listarProyectosPorUsuario(usuarioId);
        return ResponseEntity.ok(proyectos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        Proyecto actualizado = proyectoService.actualizarProyecto(id, proyecto);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }
}