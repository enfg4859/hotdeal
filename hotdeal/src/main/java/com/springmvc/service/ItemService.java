package com.springmvc.service;

import java.util.List;

import com.springmvc.domain.Item;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(int id);
    Item createItem(Item item);
    Item updateItem(int id, Item item);
    void deleteItem(int id);
}