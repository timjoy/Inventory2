package com.example.Inventory2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {
    List<Item> findByName(String name);
    Item findByID(long id);

//    Iterable<Object> findByName(String muffler);
}