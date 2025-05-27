package com.example.servicio.service;

import com.example.servicio.model.Categoria;
import com.example.servicio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerCategoriaPorId(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    public Categoria actualizarCategoria(Long idCategoria, Categoria categoriaActualizada) {
        if (categoriaRepository.existsById(idCategoria)) {
            categoriaActualizada.setIdCategoria(idCategoria);
            return categoriaRepository.save(categoriaActualizada);
        }
        return null;
    }

    public void eliminarCategoria(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}