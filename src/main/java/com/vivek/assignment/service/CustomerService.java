package com.vivek.assignment.service;

import com.vivek.assignment.models.Customer;
import com.vivek.assignment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        existing.setName(updatedCustomer.getName());
        existing.setEmail(updatedCustomer.getEmail());
        existing.setAddress(updatedCustomer.getAddress());
        existing.setPhone(updatedCustomer.getPhone());
        return customerRepository.save(existing);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

