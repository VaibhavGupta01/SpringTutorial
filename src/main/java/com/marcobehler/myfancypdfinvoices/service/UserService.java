package com.marcobehler.myfancypdfinvoices.service;

import com.marcobehler.myfancypdfinvoices.model.User;

import java.util.UUID;

public class UserService {
    public User findById(String userId) {
        String name = UUID.randomUUID().toString();

        return new User(userId,name);
    }
}
