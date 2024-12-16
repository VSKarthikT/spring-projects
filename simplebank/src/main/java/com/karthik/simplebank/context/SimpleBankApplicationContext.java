package com.karthik.simplebank.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.Appfire;
import com.karthik.simplebank.service.TransactionService;
import com.karthik.simplebank.service.UserService;

@Configuration
@ComponentScan(basePackageClasses = Appfire.class)
@PropertySource("classpath:/application.properties")
public class SimpleBankApplicationContext {
  public UserService userService() {
    return new UserService();
  }

  public TransactionService transactionService(UserService userService) {
    return new TransactionService(userService);
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
