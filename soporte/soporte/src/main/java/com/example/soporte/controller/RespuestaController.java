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

    @GetMapping("/{idRespuesta}")
    public ResponseEntity<Respuesta> obtenerPorId(@PathVariable Long idRespuesta) {
        Respuesta respuesta = respuestaService.obtenerRespuestaPorId(idRespuesta);
        return respuesta != null ? ResponseEntity.ok(respuesta) : ResponseEntity.notFound().build();
    }

    @GetMapping("/ticket/{ticketId}")
    public ResponseEntity<List<Respuesta>> listarPorTicket(@PathVariable Long ticketId) {
        return ResponseEntity.ok(respuestaService.listarTicketsId(ticketId));
    }

    @PutMapping("/{idRespuesta}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable Long idRespuesta, @RequestBody Respuesta respuesta) {
        Respuesta actualizada = respuestaService.actualizarRespuesta(idRespuesta, respuesta);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idRespuesta}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idRespuesta) {
        respuestaService.eliminarRespuesta(idRespuesta);
        return ResponseEntity.noContent().build();
    }
}