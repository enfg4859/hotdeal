package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.Item;
import com.springmvc.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	private final ItemRepository itemRepository;

	@Autowired
	public ItemServiceImpl(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public Item getItemById(int id) {
		return null;
	}

	@Override
	public Item createItem(Item item) {
		itemRepository.save(item);
		return null;
	}

	@Override
	public Item updateItem(int id, Item item) {
		return null;
	}

	@Override
	public void deleteItem(int id) {
		itemRepository.deleteById(id);
	}
}