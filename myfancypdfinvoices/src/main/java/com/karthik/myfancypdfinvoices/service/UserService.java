package com.karthik.myfancypdfinvoices.service;

import com.karthik.myfancypdfinvoices.model.User;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UserService {

  public User findById(String id) {
    String randomName = UUID.randomUUID().toString();
    return new User(id, randomName);
  }

}
