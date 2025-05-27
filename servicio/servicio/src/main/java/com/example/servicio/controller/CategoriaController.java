package com.example.servicio.controller;

import com.example.servicio.model.Categoria;
import com.example.servicio.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> crear(@RequestBody Categoria categoria) {
        Categoria creada = categoriaService.crearCategoria(categoria);
        return ResponseEntity.ok(creada);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @GetMapping("/{idCategoria}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long idCategoria) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(idCategoria);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{idCategoria}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long idCategoria, @RequestBody Categoria categoria) {
        Categoria actualizada = categoriaService.actualizarCategoria(idCategoria, categoria);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idCategoria}")
    public ResponseEntity<Void> eliminar(@PathVariable Long idCategoria) {
        categoriaService.eliminarCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }
}