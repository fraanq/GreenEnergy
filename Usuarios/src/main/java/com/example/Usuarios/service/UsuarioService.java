package com.example.Usuarios.service;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuarios.model.Usuario;
import com.example.Usuarios.repository.UsuarioRepository;


@Service
@Transactional

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RolService rolService;
    
    //metodo para buscar todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    //metodo para buscar un usuario por id
    public Usuario BuscarUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    //metodo para crear un usuario
    public void CrearUsuario(Usuario NuevoUsuario) {
        NuevoUsuario.setNombre(NuevoUsuario.getNombre().toUpperCase());
        NuevoUsuario.setApellido(NuevoUsuario.getApellido().toUpperCase());
        NuevoUsuario.setFecha_nacimiento(NuevoUsuario.getFecha_nacimiento());
        NuevoUsuario.setTelefono(NuevoUsuario.getTelefono());
        NuevoUsuario.setEmail(NuevoUsuario.getEmail().toLowerCase());
        NuevoUsuario.setClave(EncriptarClave(NuevoUsuario.getClave()));
        NuevoUsuario.setRol(rolService.BuscarRolId(NuevoUsuario.getRol().getId_rol()));
        usuarioRepository.save(NuevoUsuario);
    }
    

    //metodo para actualizar un usuario
    public void ActualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    //metodo para eliminar un usuario
    public void EliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    //metodo para encriptar la clave
    public String EncriptarClave(String clave) {
        String claveEncriptada = "";
        for (int i = 0; i < clave.length(); i++) {
            claveEncriptada += (char) (clave.charAt(i) + 1);
        }
        return claveEncriptada;
    }

    //metodo para obtener una direccion de un usuario
    
    //metodo para obtener ticket de un usuario

    //metodo obtener los contactos de un usuario
    
}
