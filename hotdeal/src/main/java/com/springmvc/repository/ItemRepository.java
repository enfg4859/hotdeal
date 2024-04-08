package com.springmvc.repository;

import java.util.List;

import com.springmvc.domain.Item;

public interface ItemRepository {

    List<Item> findAll();

    Item findById(int id);

    Item save(Item item);

    Item update(Item item);

    void deleteById(int id);
}
