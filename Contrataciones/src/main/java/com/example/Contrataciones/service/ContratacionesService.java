package com.example.Contrataciones.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Contrataciones.model.Contrataciones;
import com.example.Contrataciones.repository.ContratacionesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ContratacionesService {
    @Autowired
    private ContratacionesRepository contratacionesRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    
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
        if (contratacionesRepository.obtenercontratacionById(contratacion.getIdcontrataciones()).isPresent()) {
            throw new RuntimeException("La contratacion ya existe");
        }
        return contratacionesRepository.save(contratacion);
    }

    //metodo para actualizar una contratacion
    public Contrataciones actualizarContratacion(Contrataciones contratacion) {
        Contrataciones contratacionExistente = contratacionesRepository.obtenercontratacionById(contratacion.getIdcontrataciones())
                .orElseThrow(() -> new RuntimeException("Contratacion no encontrada"));
        contratacionExistente.setTipoContratacion(contratacion.getTipoContratacion());
        contratacionExistente.setFechaContratacion(contratacion.getFechaContratacion());
        contratacionExistente.setEstado(contratacion.getEstado());
        return contratacionesRepository.save(contratacionExistente);
    }
}
