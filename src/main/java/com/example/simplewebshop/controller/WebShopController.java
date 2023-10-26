package com.example.simplewebshop.controller;

import com.example.simplewebshop.model.Basket;
import com.example.simplewebshop.model.MyUser;
import com.example.simplewebshop.persistence.BasketRepository;
import com.example.simplewebshop.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class WebShopController {

    private final BasketRepository basketRepository;

    @GetMapping("/{userId}/basket")
    public String getBasket(@PathVariable Long userId, Model model) {
        model.addAttribute("basket", this.basketRepository.findBasketByUserId(userId));
        return "basket";
    }

}
