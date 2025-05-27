package com.example.Contrataciones.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Contrataciones.WebClient.DireccionClient;
import com.example.Contrataciones.WebClient.ServicioClient;
import com.example.Contrataciones.WebClient.UsuarioClient;
import com.example.Contrataciones.model.Contrataciones;
import com.example.Contrataciones.repository.ContratacionesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ContratacionesService {
    @Autowired
    private ContratacionesRepository contratacionesRepository;
    @Autowired
    private ServicioClient servicioClient;
    @Autowired
    private UsuarioClient usuarioClient;
    @Autowired
    private DireccionClient direccionClient;

    
    //metodo para obtener todas las contrataciones
    public List<Contrataciones> obtenerTodasContrataciones() {
        return contratacionesRepository.findAll();
    }
    //metodo para obtener todas las contrataciones por id de usuario
    public Contrataciones obtenercontratacionById(Long id) {
        return contratacionesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contratacion no encontrada"));
    }

    // metodo para agregar un nuevo proyecto
    public Contrataciones saveContrataciones(Contrataciones nueva) {
        // verificar si el proyecto consultando al microservicio de proyecto
        Map<String, Object> servicio = servicioClient.getServicioById(nueva.getIdservicio());
        // verifico si me trajo el estado o no
        if (servicio == null || servicio.isEmpty()) {
            throw new RuntimeException("Servicio no encontrado");
        }
        // verificar si el proyecto exisyte consultando al microservicio de proyecto
        Map<String, Object> direccion = direccionClient.(nueva.getIddireccion());
        // verifico si me trajo el usuario o no
        if (direccion == null || direccion.isEmpty()) {
            throw new RuntimeException("Direccion no encontrada");

        }
        Map<String, Object> usuario = usuarioClient.getUsuarioById(nueva.getIdusuario());
        // verifico si me trajo el estado o no
        if (usuario == null || usuario.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }
        return contratacionesRepository.save(nuevaContrataciones);

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
