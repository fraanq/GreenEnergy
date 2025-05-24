package com.example.soporte.service;


import com.example.soporte.model.Ticket;
import com.example.soporte.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket crearTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public List<Ticket> listarTickets() {
        return ticketRepository.findAll();
    }

    public Ticket obtenerTicketPorId(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket actualizarTicket(Long id, Ticket ticketActualizado) {
        if (ticketRepository.existsById(id)) {
            ticketActualizado.setId(id);
            return ticketRepository.save(ticketActualizado);
        }
        return null;
    }

    public void eliminarTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}