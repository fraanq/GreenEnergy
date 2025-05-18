package com.example.Usuarios.service;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Usuarios.model.Usuarios;
import com.example.Usuarios.repository.UsuarioRepository;


@Service
@Transactional

public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @autowired
    private RolService rolService;
    
    //metodo para buscar todos los usuarios
    public List<Usuarios> ListaUsuario() {
        return usuarioRepository.findAll();
    }

    //metodo para buscar un usuario por id
    public Usuarios BuscarUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElse(())->new RuntimeException("Usuario no encontrado");
    }

    //metodo para crear un usuario
    public void CrearUsuario(Usuarios usuario) {
        usuario.setClave(EncriptarClave(usuario.getClave()));
        usuarioRepository.save(usuario);
    }

    //metodo para actualizar un usuario
    public void ActualizarUsuario(Usuarios usuario) {
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
