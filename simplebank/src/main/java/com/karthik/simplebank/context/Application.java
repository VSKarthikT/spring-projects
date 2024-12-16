package com.karthik.simplebank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.simplebank.service.TransactionService;
import com.karthik.simplebank.service.UserService;

public class Application {
  public static final UserService userService = new UserService();
  public static final TransactionService transactionService = new TransactionService(userService);
  public static final ObjectMapper objectMapper = new ObjectMapper();
}
