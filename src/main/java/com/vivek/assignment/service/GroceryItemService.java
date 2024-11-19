package com.vivek.assignment.service;

import com.vivek.assignment.models.GroceryItem;
import com.vivek.assignment.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;


    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public GroceryItem createItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        GroceryItem existing = groceryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        existing.setName(updatedItem.getName());
        existing.setCategory(updatedItem.getCategory());
        existing.setPrice(updatedItem.getPrice());
        existing.setQuantity(updatedItem.getQuantity());
        return groceryItemRepository.save(existing);
    }

    public void deleteItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
