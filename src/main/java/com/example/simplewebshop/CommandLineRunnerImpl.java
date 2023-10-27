package com.example.simplewebshop;

import com.example.simplewebshop.model.Basket;
import com.example.simplewebshop.model.BasketItem;
import com.example.simplewebshop.model.MyUser;
import com.example.simplewebshop.model.Product;
import com.example.simplewebshop.model.Status;
import com.example.simplewebshop.persistence.BasketRepository;
import com.example.simplewebshop.persistence.ProductRepository;
import com.example.simplewebshop.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final BasketRepository basketRepository;


    @Override
    public void run(String... args) throws Exception {
        List<MyUser> myUsers = createMockUser();
        List<Product> products = createMockProducts();
        List<Basket> baskets = new ArrayList<>();

        for (int i = 0; i < myUsers.size(); i++) {
            Basket basket = new Basket();
            basket.setUser(myUsers.get(i));
            basket.addBasketItem(new BasketItem(products.get(i), i+2));
            basket.addBasketItem(new BasketItem(products.get(i+2), i*2+1));
            basket.setStatus(Status.CHECKOUT);
            baskets.add(basket);
        }

        productRepository.saveAll(products);
        userRepository.saveAll(myUsers);
        basketRepository.saveAll(baskets);
    }


    private List<MyUser> createMockUser() {
        MyUser myUser1 = new MyUser("Hans", "Wurst");
        MyUser myUser2 = new MyUser("Moini", "Moinsen");
        return List.of(myUser1, myUser2);
    }

    private List<Product> createMockProducts() {
        Product product1 = new Product("GTA 4");
        Product product2 = new Product("Need for Speed - Most Wanted");
        Product product3 = new Product("Age of Empires");
        Product product4 = new Product("Dark Souls");
        return List.of(product1, product2, product3, product4);
    }

}
