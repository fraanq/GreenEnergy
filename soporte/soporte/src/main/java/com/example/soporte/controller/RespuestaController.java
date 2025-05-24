package com.example.soporte.controller;

import com.example.soporte.model.Respuesta;
import com.example.soporte.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @PostMapping
    public ResponseEntity<Respuesta> crear(@RequestBody Respuesta respuesta) {
        return ResponseEntity.ok(respuestaService.crearRespuesta(respuesta));
    }

    @GetMapping
    public ResponseEntity<List<Respuesta>> listar() {
        return ResponseEntity.ok(respuestaService.listarRespuestas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> obtener(@PathVariable Long id) {
        Respuesta respuesta = respuestaService.obtenerPorId(id);
        return respuesta != null ? ResponseEntity.ok(respuesta) : ResponseEntity.notFound().build();
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<Respuesta>> listarPorTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(respuestaService.listarPorTicket(ticketId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable Long id, @RequestBody Respuesta respuesta) {
        Respuesta actualizada = respuestaService.actualizar(id, respuesta);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        respuestaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}