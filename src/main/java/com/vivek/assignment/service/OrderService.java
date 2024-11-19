package com.vivek.assignment.service;

import com.vivek.assignment.models.OrderEntity;
import com.vivek.assignment.repository.GroceryItemRepository;
import com.vivek.assignment.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderEntity createOrder(OrderEntity orderEntity) {
        // Calculate total price
        double totalPrice = orderEntity.getGroceryItems().stream()
                .mapToDouble(groceryItem -> groceryItem.getPrice() * groceryItem.getQuantity())
                .sum();
        orderEntity.setTotalPrice(totalPrice);
        orderEntity.setOrderDate(LocalDate.now());

        // Save the order
        return orderRepository.save(orderEntity);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
