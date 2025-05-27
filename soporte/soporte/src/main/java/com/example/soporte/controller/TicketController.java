package com.example.soporte.controller;

import com.example.soporte.model.Ticket;
import com.example.soporte.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> crear(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.crearTicket(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> listar() {
        return ResponseEntity.ok(ticketService.listarTickets());
    }

    @GetMapping("/{idTicket}")
    public ResponseEntity<Ticket> obtenerPorId(@PathVariable Long idTicket) {
        Ticket ticket = ticketService.obtenerTicketPorId(idTicket);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{idTicket}")
    public ResponseEntity<Ticket> actualizar(@PathVariable Long idTicket, @RequestBody Ticket ticket) {
        Ticket actualizado = ticketService.actualizarTicket(idTicket, ticket);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idTicket}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idTicket) {
        ticketService.eliminarTicket(idTicket);
        return ResponseEntity.noContent().build();
    }
}
