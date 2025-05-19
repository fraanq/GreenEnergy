package com.example.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Usuarios.model.Usuario;
import com.example.Usuarios.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuarios")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //metodo para buscar todos los usuarios
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        List<Usuario> usuarios = usuarioService.obtenerUsuarios();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    //metodo para buscar un usuario por id
    @GetMapping("/id")
    public ResponseEntity<Usuario> obtenerUsuarioId(Long id){
        Usuario user = usuarioService.BuscarUsuarioId(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }
    //metodo para actualizar un usuario
    @PutMapping("/actualizar")
    public ResponseEntity<Usuario> actualizarUsuario(Long id, Usuario usuario){
        Usuario user = usuarioService.BuscarUsuarioId(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        usuarioService.ActualizarUsuario(id, usuario);
        return ResponseEntity.ok(usuario);
    }
    //metodo para crear un usuario
    @PostMapping("/nuevo")
    public ResponseEntity<Usuario> crearUsuario(Usuario NuevoUsuario){
        usuarioService.CrearUsuario(NuevoUsuario);
        return ResponseEntity.ok(NuevoUsuario);
    }
    //metodo para eliminar un usuario
    @DeleteMapping("/eliminar")
    public ResponseEntity<Usuario> eliminarUsuario(Long id){
        Usuario user = usuarioService.BuscarUsuarioId(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        usuarioService.EliminarUsuario(id);
        return ResponseEntity.ok(user);
    }
    
    
    
    



}