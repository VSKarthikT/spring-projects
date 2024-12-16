package com.karthik.simplebank.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.karthik.simplebank.model.Transaction;
import com.karthik.simplebank.model.User;

@Component
public class TransactionService {
  @Value("${bank.name}")
  String bankname;
  private final UserService userService;

  // Dependacy injection of userservice
  public TransactionService(UserService userService) {
    this.userService = userService;
  }

  List<Transaction> transactions = new CopyOnWriteArrayList<>();

  public List<Transaction> findall() {
    return transactions;

  }

  public Transaction create(String userId, float amount) {
    userService.addUser(userId);
    User user = userService.findbyId(userId);
    if (user == null) {
      throw new IllegalStateException();
    }
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timestamp = now.format(formatter);
    Transaction transaction = new Transaction(userId, timestamp, amount);
    transactions.add(transaction);
    return transaction;
  }
}
