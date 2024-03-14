package org.example.crud.controller;

import org.example.crud.domain.Item;
import org.example.crud.repository.ItemRepository;
import org.example.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/item")
class ItemController {

    @Autowired
    ItemService service;

    @GetMapping
    public List<Item> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Item getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.create(item);
    }

    @PutMapping("{id}")
    public Item update(@PathVariable("id") Long id, @RequestBody Item item) {
        return service.update(id, item);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return service.delete(id);
    }
}