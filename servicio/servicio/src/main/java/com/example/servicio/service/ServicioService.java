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

    public Servicio obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public List<Servicio> listarPorCategoria(Long categoriaId) {
        return servicioRepository.findByCategoriaId(categoriaId);
    }

    public Servicio actualizarServicio(Long id, Servicio servicioActualizado) {
        if (servicioRepository.existsById(id)) {
            servicioActualizado.setId(id);
            return servicioRepository.save(servicioActualizado);
        }
        return null;
    }

    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
