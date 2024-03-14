package org.example.crud.service;

import lombok.AllArgsConstructor;
import org.example.crud.domain.Categoria;
import org.example.crud.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CategoriaService {

    // A anotação @Autowired é usada para injetar dependências automaticamente.
    // A anotação @Autowired pode ser usada para injetar beans em propriedades, métodos e construtores.

    public final CategoriaRepository repository;

    public List<Categoria> getAll() {
        try {
            List<Categoria> items = new ArrayList<Categoria>();

            // O método findAll() retorna um Iterable que é percorrido com o método
            // forEach() que adiciona cada item à lista items.
            // O operador :: é usado para criar expressões lambda mais claras e concisas.
            // A expressão lambda items::add é usada para adicionar cada item retornado pelo
            // método findAll() à lista items.
            // A expressão lambda items::add é equivalente a: (item) -> items.add(item)
            repository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Categoria getById(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        if (categoria.isPresent()) {
            return categoria.get();
        }
        return null;
    }

    public Categoria create(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria update(Long id, Categoria item) {
        Optional<Categoria> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            Categoria existingItem = existingItemOptional.get();
            existingItem.setNome(item.getNome());
            return repository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}