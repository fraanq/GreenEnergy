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

    public Estado obtenerPorId(Long idEstado) {
        return estadoRepository.findById(idEstado).orElse(null);
    }

    public Estado actualizar(Long idEstado, Estado estadoActualizado) {
        if (estadoRepository.existsById(idEstado)) {
            estadoActualizado.setIdEstado(idEstado); // ✅ CORREGIDO
            return estadoRepository.save(estadoActualizado);
        }
        return null;
    }

    public void eliminar(Long idEstado) {
        estadoRepository.deleteById(idEstado);
    }
}