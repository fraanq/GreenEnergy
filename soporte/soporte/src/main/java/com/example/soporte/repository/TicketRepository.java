package com.example.soporte.repository;

import com.example.soporte.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Aquí puedes agregar metodos personalizados si es necesario
}