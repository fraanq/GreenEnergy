package com.example.Usuario.controller;

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

import com.example.Usuario.model.Rol;
import com.example.Usuario.service.RolService;


@RestController
@RequestMapping("/api/Roles")
public class RolController {
    @Autowired
    private RolService rolService;
    
    //metodo para buscar todos los roles
    @GetMapping
    public ResponseEntity<List<Rol>> ObtenerTodosRol(){
        List<Rol> roles = rolService.ObtenerTodosRol();
        if(roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }
    //metodo para buscar un rol por id
    @GetMapping("/{id}")
    public ResponseEntity<Rol> ObtenerRolId(Long id){
        Rol rol = rolService.BuscarRolId(id);
        if(rol == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rol);
    }


    //metodo para crear un nuevo rol
    @PostMapping
    public ResponseEntity<?> CrearRol(Rol rol){
        if(rol.getNombre() == null || rol.getNombre().isEmpty()){
            return ResponseEntity.badRequest().body("El campo 'nombre' no puede ser nulo");
        }
        Rol nuevoRol = rolService.CrearRol(rol);
        return ResponseEntity.ok(nuevoRol);
    }
    //metodo para actualizar un rol
    @PutMapping("/{id}")
    public ResponseEntity<Rol> ActualizarRol(@PathVariable Long id,@RequestBody Rol rol){
        try {
            Rol rolActualizado = rolService.ActualizarRol(rol);
            return ResponseEntity.ok(rolActualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    //metodo para eliminar un rol
    @DeleteMapping("/{id}")
    public ResponseEntity<?> EliminarRol(@PathVariable Long id){
        try {
            rolService.eliminarRol(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}