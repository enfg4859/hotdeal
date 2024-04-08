package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.Item;
import com.springmvc.service.ItemService;

@Controller
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @ResponseBody // 이 어노테이션을 추가하여 반환 값을 HTTP 응답 본문으로 변환
    public List<Item> getAllItems(Model model) {
    	model.addAttribute("item", itemService.getAllItems());
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable("id") int id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public String createItem(@ModelAttribute Item item) {
        itemService.createItem(item);
        return "main";
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable("id") int id, @RequestBody Item item) {
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
    }
}