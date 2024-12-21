package com.karthik.myfancypdfinvoices_springboot.model;

public class User {
  private String id;
  private String name;

  public User(String id, String name) {
    this.name = name;
    this.id = id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

}
