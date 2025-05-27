package com.example.servicio.service;

import com.example.servicio.model.Servicio;
import com.example.servicio.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public Servicio crearServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public List<Servicio> obtenerTodosLosServicios() {
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicioPorId(Long idServicio) {
        return servicioRepository.findById(idServicio).orElse(null);
    }

    public List<Servicio> listarPorCategoria(Long categoriaId) {
        return servicioRepository.findByCategoriaId(categoriaId);
    }

    public Servicio actualizarServicio(Long idServicio, Servicio servicioActualizado) {
        if (servicioRepository.existsById(idServicio)) {
            servicioActualizado.setIdServicio(idServicio); 
            return servicioRepository.save(servicioActualizado);
        }
        return null;
    }

    public void eliminarServicio(Long idServicio) {
        servicioRepository.deleteById(idServicio);
    }
}
