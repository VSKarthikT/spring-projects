package com.karthik.simplebank.model;

import java.util.UUID;

public class Transaction {
  private String id, userId, timestamp;
  private Float amount;

  public Transaction(String userId, String timestamp, Float amount) {
    this.id = UUID.randomUUID().toString();
    this.userId = userId;
    this.timestamp = timestamp;
    this.amount = amount;
  }

  public String getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public Float getAmount() {
    return amount;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

}
