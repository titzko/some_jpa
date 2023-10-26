package com.example.simplewebshop.persistence;


import com.example.simplewebshop.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long> {
}
