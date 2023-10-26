package com.example.simplewebshop;

import com.example.simplewebshop.model.MyUser;
import com.example.simplewebshop.model.Product;
import com.example.simplewebshop.persistence.ProductRepository;
import com.example.simplewebshop.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        List<MyUser> myUsers = createMockUser();
        List<Product> products = createMockProducts();

        for(int i=0; i<myUsers.size(); i++) {
            List<Product> selectedProducts = List.of(products.get(i), products.get(i+2));
            myUsers.get(i).setProducts(selectedProducts);
        }

        productRepository.saveAll(products);
        userRepository.saveAll(myUsers);

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
