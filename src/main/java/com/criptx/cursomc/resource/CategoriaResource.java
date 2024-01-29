package com.criptx.cursomc.resource;

import com.criptx.cursomc.domain.Categoria;
import com.criptx.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/categorias")

public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Categoria objeto = service.buscar(id);

       return ResponseEntity.ok().body(objeto);


    }
}
