package com.example.resena.controller;

import com.example.resena.model.Resena;
import com.example.resena.service.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @PostMapping
    public ResponseEntity<Resena> crearResena(@RequestBody Resena resena) {
        Resena creada = resenaService.crearResena(resena);
        return ResponseEntity.ok(creada);
    }

    @GetMapping("/{idResena}")
    public ResponseEntity<Resena> obtenerPorId(@PathVariable Long idResena) {
        Resena resena = resenaService.obtenerResenaPorId(idResena);
        if (resena != null) {
            return ResponseEntity.ok(resena);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Resena>> listarTodos() {
        List<Resena> resenas = resenaService.listarResenas();
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/proyecto/{proyectoId}")
    public ResponseEntity<List<Resena>> listarPorProyecto(@PathVariable Long proyectoId) {
        List<Resena> resenas = resenaService.listarPorProyecto(proyectoId);
        return ResponseEntity.ok(resenas);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Resena>> listarPorUsuario(@PathVariable Long usuarioId) {
        List<Resena> resenas = resenaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(resenas);
    }

    @PutMapping("/{idResena}")
    public ResponseEntity<Resena> actualizarResena(@PathVariable Long idResena, @RequestBody Resena resena) {
        Resena actualizado = resenaService.actualizarResena(idResena, resena);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{idResena}")
    public ResponseEntity<Void> eliminarResena(@PathVariable Long idResena) {
        resenaService.eliminarResena(idResena);
        return ResponseEntity.noContent().build();
    }
}
