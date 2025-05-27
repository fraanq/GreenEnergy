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

    public Proyecto obtenerProyectoPorId(Long idProyecto) {
        return repository.findById(idProyecto).orElse(null);
    }

    public List<Proyecto> listarProyectos() {
        return repository.findAll();
    }

    public List<Proyecto> listarProyectosPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public Proyecto actualizarProyecto(Long idProyecto, Proyecto proyecto) {
        proyecto.setIdProyecto(idProyecto); 
        return repository.save(proyecto);
    }

    public void eliminarProyecto(Long idProyecto) {
        repository.deleteById(idProyecto);
    }
}
