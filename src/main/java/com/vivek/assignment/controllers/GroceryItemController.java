package com.vivek.assignment.controllers;

import com.vivek.assignment.models.GroceryItem;
import com.vivek.assignment.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return groceryItemService.getAllItems();
    }

    @PostMapping
    public GroceryItem createItem(@RequestBody GroceryItem item) {
        return groceryItemService.createItem(item);
    }

    @PutMapping("/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem updatedItem) {
        return groceryItemService.updateItem(id, updatedItem);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        groceryItemService.deleteItem(id);
    }
}

