package com.example.proyecto.service;


import com.example.proyecto.model.Proyecto;
import com.example.proyecto.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository repository;

    public Proyecto crearProyecto(Proyecto proyecto) {
        return repository.save(proyecto);
    }

    public Proyecto obtenerProyectoPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Proyecto> listarProyectos() {
        return repository.findAll();
    }

    public List<Proyecto> listarProyectosPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Proyecto actualizarProyecto(Long id, Proyecto proyecto) {
        proyecto.setId(id);
        return repository.save(proyecto);
    }

    public void eliminarProyecto(Long id) {
        repository.deleteById(id);
    }
}
