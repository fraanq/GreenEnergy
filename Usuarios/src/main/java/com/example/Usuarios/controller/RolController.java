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

import com.example.Usuarios.model.Rol;
import com.example.Usuarios.service.RolService;

@RestController
@RequestMapping("/api/v1/Roles")
public class RolController {
    @Autowired
    private RolService rolService;
    //metodo para buscar todos los roles
    @GetMapping("/all")
    public ResponseEntity<List<Rol>> ObtenerTodosRol(){
        List<Rol> roles = rolService.ObtenerTodosRol();
        if(roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }
    //metodo para buscar un rol por id
    @GetMapping("/id")
    public ResponseEntity<Rol> ObtenerRolId(Long id){
        Rol rol = rolService.BuscarRolId(id);
        if(rol == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rol);
    }
    //metodo para crear un nuevo rol
    @PostMapping("/nuevo")
    public ResponseEntity<Rol> CrearRol(Rol rol){
        rolService.CrearRol(rol);
        return ResponseEntity.ok(rol);
    }
    //metodo para actualizar un rol
    @PutMapping("/actualizar")
    public ResponseEntity<Rol> ActualizarRol(Rol rol){
        Rol rolExistente = rolService.BuscarRolId(rol.getId_rol());
        if(rolExistente == null){
            return ResponseEntity.notFound().build();
        }
        rolService.ActualizarRol(rol);
        return ResponseEntity.ok(rol);
    }
    //metodo para eliminar un rol
    @DeleteMapping("/eliminar")
    public ResponseEntity<Rol> EliminarRol(Long id){
        Rol rol = rolService.BuscarRolId(id);
        if(rol == null){
            return ResponseEntity.notFound().build();
        }
        rolService.EliminarRol(id);
        return ResponseEntity.ok(rol);
    }
}