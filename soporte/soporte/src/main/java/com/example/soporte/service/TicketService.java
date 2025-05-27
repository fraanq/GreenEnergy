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

    public List<Ticket> listarTicketsId() {
        return ticketRepository.findAll();
    }

    public Ticket obtenerTicketPorId(Long idTicket) {
        return ticketRepository.findById(idTicket).orElse(null);
    }

    public Ticket actualizarTicket(Long idTicket, Ticket ticketActualizado) {
        if (ticketRepository.existsById(idTicket)) {
            ticketActualizado.setIdTicket(idTicket); 
            return ticketRepository.save(ticketActualizado);
        }
        return null;
    }

    public void eliminarTicket(Long idTicket) {
        ticketRepository.deleteById(idTicket);
    }
}