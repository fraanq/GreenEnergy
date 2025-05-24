package com.example.soporte.service;

import com.example.soporte.model.Respuesta;
import com.example.soporte.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta crearRespuesta(Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> listarRespuestas() {
        return respuestaRepository.findAll();
    }

    public Respuesta obtenerPorId(Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }

    public List<Respuesta> listarPorTicket(Long ticketId) {
        return respuestaRepository.findByTicketId(ticketId);
    }

    public Respuesta actualizar(Long id, Respuesta respuestaActualizada) {
        if (respuestaRepository.existsById(id)) {
            respuestaActualizada.setId(id);
            return respuestaRepository.save(respuestaActualizada);
        }
        return null;
    }

    public void eliminar(Long id) {
        respuestaRepository.deleteById(id);
    }
}
