package org.example.crud.controller;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.crud.domain.Categoria;
import org.example.crud.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/categoria")
class CategoriaController {


    CategoriaService service;

    @GetMapping
    public List<Categoria> getAll() {
        // Vemos aqui uma chamada à camada de serviço para buscar as categorias.
        // A camada de serviço não conhece o HTTP.
        // A camada de serviço lida com questões de negócio, o que inclui acesso aos dados da aplicação
        // A camada de controle lida com questões de HTTP
        List<Categoria> items = service.getAll();
        return items;
    }

    @GetMapping("{id}")
    public Categoria getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Categoria create(@RequestBody Categoria item) {
        Categoria categoria = service.create(item);
        return categoria;
    }

    @PutMapping("{id}")
    public Categoria update(@PathVariable("id") Long id, @RequestBody Categoria item) {
        return service.update(id, item);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}