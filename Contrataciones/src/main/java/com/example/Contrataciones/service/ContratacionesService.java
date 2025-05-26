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
    public List<Contrataciones> obtenerTodasContrataciones() {
        return contratacionesRepository.findAll();
    }
    //metodo para obtener todas las contrataciones por id de usuario
    public Contrataciones obtenercontratacionById(Long id) {
        return contratacionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratacion no encontrada"));
    }

    //metodo para crear una nueva contratacion
    public Contrataciones crearContratacion(Contrataciones contratacion) {
        return contratacionesRepository.save(contratacion);
    }

    //metodo para actualizar una contratacion
    public Contrataciones actualizarContratacion(long id,Contrataciones contratacion) {
    Contrataciones contratacionExistente = contratacionesRepository.findById(contratacion.getIdcontratacion())
            .orElseThrow(() -> new RuntimeException("Contratación no encontrada"));
        contratacionExistente.setTipoContratacion(contratacion.getTipoContratacion());
        contratacionExistente.setFechaContratacion(contratacion.getFechaContratacion());
        contratacionExistente.setEstado(contratacion.getEstado());
        contratacionExistente.setIdusuario(contratacion.getIdusuario());
        contratacionExistente.setIddireccion(contratacion.getIddireccion());
        contratacionExistente.setIdservicio(contratacion.getIdservicio());

        return contratacionesRepository.save(contratacionExistente);
    }
    //metodo para eliminar una contratacion
    public void eliminarContratacion(Long id) {
        contratacionesRepository.deleteById(id);

    }
}
