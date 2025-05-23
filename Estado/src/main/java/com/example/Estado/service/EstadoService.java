package com.example.Estado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Estado.model.Estado;
import com.example.Estado.repository.EstadoRepository;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    //metodo para obtener todos los estados
    public List<Estado> obtenerTodosEstados() {
        return estadoRepository.findAll();
    }
    //metodo para obtener un estado por id
    public Estado obtenerEstadoById(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado no encontrado"));
        
    }
    //metodo para crear un estado
    public Estado NuevoEstado(Estado estado) {
        return estadoRepository.save(estado);
    }
    //metodo para actualizar un estado
    public Estado actualizarEstado(Long id, Estado estado) {
        Estado existeEstado = obtenerEstadoById(id);
        existeEstado.setNombre(estado.getNombre());
        existeEstado.setTipo(estado.getTipo());
        return estadoRepository.save(existeEstado);
    }
    
    //metodo para eliminar un estado
    public void eliminarEstado(Long id) {
        Estado existeEstado = obtenerEstadoById(id);
        estadoRepository.delete(existeEstado);
    }
    @OneToOne
    @JoinColumn(name = "id_modulo")
    private Estado estado;

    @OneToOne
    @JoinColumn(name = "id_privilegio")
    private Estado privilegio;
}
