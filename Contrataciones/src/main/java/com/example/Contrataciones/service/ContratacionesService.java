package com.example.Contrataciones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Contrataciones.model.Contrataciones;
import com.example.Contrataciones.repository.ContratacionesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContratacionesService {
    @Autowired
    private ContratacionesRepository contratacionesRepository;

    //metodo para obtener todas las contrataciones
    public List<Contrataciones> getAllContrataciones() {
        return contratacionesRepository.findAll();
    }
    //metodo para obtener una contratacion por id
    public Contrataciones getContratacionById(Long id) {
        return contratacionesRepository.findById(id).orElseThrow(() -> new RuntimeException("Contratacion no encontrada"));
        
    }

    //metodo para crear una contratacion
    public Contrataciones createContratacion(Contrataciones contratacion) {
        return contratacionesRepository.save(contratacion);
    }
    //metodo para actualizar una contratacion
    public Contrataciones actualizarContratacion(Long id, Contrataciones contratacion) {
        Contrataciones existeContratacion = getContratacionById(id);
        existeContratacion.setTipoContratacion(contratacion.getTipoContratacion());
        existeContratacion.setFechaContratacion(contratacion.getFechaContratacion());
        existeContratacion.setEstado(contratacion.getEstado());
        return contratacionesRepository.save(existeContratacion);
    }

    //metodo para eliminar una contratacion
    public void eliminarContratacion(Long id) {
        Contrataciones existeContratacion = getContratacionById(id);
        contratacionesRepository.delete(existeContratacion);
    }
}
