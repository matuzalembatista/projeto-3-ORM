package org.example.crud.repository;

import org.example.crud.domain.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository  extends CrudRepository<Item, Long> {
}
