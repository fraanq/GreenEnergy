package com.example.soporte.service;

import com.example.soporte.model.Estado;
import com.example.soporte.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado crearEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    public Estado obtenerPorId(Long id) {
        return estadoRepository.findById(id).orElse(null);
    }

    public Estado actualizar(Long id, Estado estadoActualizado) {
        if (estadoRepository.existsById(id)) {
            estadoActualizado.setId(id);
            return estadoRepository.save(estadoActualizado);
        }
        return null;
    }

    public void eliminar(Long id) {
        estadoRepository.deleteById(id);
    }
}
