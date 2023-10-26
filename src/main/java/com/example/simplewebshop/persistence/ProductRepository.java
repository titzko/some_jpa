package com.example.simplewebshop.persistence;


import com.example.simplewebshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
