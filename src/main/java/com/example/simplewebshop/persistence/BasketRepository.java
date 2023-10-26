package com.example.simplewebshop.persistence;

import com.example.simplewebshop.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findBasketByUserId(Long userId);
}
