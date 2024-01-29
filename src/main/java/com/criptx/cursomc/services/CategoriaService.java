package com.criptx.cursomc.services;

import com.criptx.cursomc.domain.Categoria;
import com.criptx.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria buscar(Integer id) {
        Optional<Categoria> objeto = repository.findById(id);
        return objeto.orElse(null);
    }
}
