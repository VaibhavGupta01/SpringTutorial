package com.marcobehler.myfancypdfinvoices.service;

import com.marcobehler.myfancypdfinvoices.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UserService {
    public User findById(String userId) {
        String name = UUID.randomUUID().toString();

        return new User(userId,name);
    }
}