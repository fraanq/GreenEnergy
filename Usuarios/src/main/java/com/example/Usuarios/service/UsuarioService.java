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
    
    //metodo para buscar todos los usuarios
    public List<Usuario> ListaUsuario() {
        return usuarioRepository.findAll();
    }

    //metodo para buscar un usuario por id
    public Usuario BuscarUsuarioId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    //metodo para crear un usuario
    public void CrearUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
        
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
    


    //metodo para actualizar la direccion de un usuario 
    public void ActualizarDireccionUsuario(Long id, String direccion) {
        Usuario usuario = BuscarUsuarioId(id);
        usuario.setDireccion(direccion);
        ActualizarUsuario(usuario);
    }

    //metodo para obtener ticket de un usuario

    //metodo obtener los contactos de un usuario
    
}
