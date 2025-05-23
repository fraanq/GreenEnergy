package com.example.Usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping
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
    //metodo para crear un nuevo usuario
   @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        if (usuario.getRol() == null || usuario.getRol().getId_rol() == null) {
            return ResponseEntity.badRequest().body("El campo 'rol.id' no puede ser nulo");
    
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.BuscarUsuarioId(usuario.getId_user());
        if (usuarioExistente == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.ActualizarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    //metodo para eliminar un usuario
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.BuscarUsuarioId(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.EliminarUsuario(id);
        return ResponseEntity.ok(usuario);
    }
    

}