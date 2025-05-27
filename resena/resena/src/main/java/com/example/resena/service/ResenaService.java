package com.example.resena.service;

import com.example.resena.model.Resena;
import com.example.resena.repository.ResenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository repository;

    // Crear nueva resena
    public Resena crearResena(Resena resena) {
        return repository.save(resena);
    }

    // Obtener una resena por ID
    public Resena obtenerResenaPorId(Long idResena) {
        return repository.findById(idResena).orElse(null);
    }

    // Listar todas las resenas
    public List<Resena> listarResenas() {
        return repository.findAll();
    }

    // Listar resenas por ID de proyecto
    public List<Resena> listarPorProyecto(Long proyectoId) {
        return repository.findByProyectoId(proyectoId);
    }

    // Listar resenas por ID de usuario
    public List<Resena> listarPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    // Actualizar una resena
    public Resena actualizarResena(Long idResena, Resena resena) {
        resena.setIdResena(idResena); // ✔️ Campo actualizado correctamente
        return repository.save(resena);
    }

    // Eliminar una resena
    public void eliminarResena(Long idResena) {
        repository.deleteById(idResena);
    }
}