package com.karthik.simplebank.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import com.karthik.simplebank.model.User;

@Component
public class UserService {

  List<User> users = new CopyOnWriteArrayList<>();

  public User findbyId(String id) {
    for (User user : users) {
      if (user.getId().equals(id)) {
        return user;
      }
    }
    return null;
  }

  public List<User> findUsers() {
    return users;
  }

  public User addUser(String id) {
    String name = UUID.randomUUID().toString();
    User user = new User(id, name);
    users.add(user);
    return user;
  }
}
