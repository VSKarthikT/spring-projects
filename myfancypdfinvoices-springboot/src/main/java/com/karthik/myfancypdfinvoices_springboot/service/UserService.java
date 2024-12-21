package com.karthik.myfancypdfinvoices_springboot.service;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.karthik.myfancypdfinvoices_springboot.model.User;

@Component
public class UserService {
  public User findById(String id) {
    String randomName = UUID.randomUUID().toString();
    return new User(id, randomName);
  }

}
