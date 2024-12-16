package com.karthik.simplebank.web;

import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.simplebank.context.SimpleBankApplicationContext;
import com.karthik.simplebank.model.Transaction;
import com.karthik.simplebank.model.User;
import com.karthik.simplebank.service.TransactionService;
import com.karthik.simplebank.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleBankServlet extends HttpServlet {
  // private TransactionService transactionService = new TransactionService();
  // private ObjectMapper objectMapper = new ObjectMapper();
  private UserService userService;
  private TransactionService transactionService;
  private ObjectMapper objectMapper;

  @Override
  public void init() throws ServletException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SimpleBankApplicationContext.class);
    this.userService = ctx.getBean(UserService.class);
    this.transactionService = ctx.getBean(TransactionService.class);
    this.objectMapper = ctx.getBean(ObjectMapper.class);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    if (request.getRequestURI().equalsIgnoreCase("/")) {
      response.setContentType("text/html; charset=UTF-8");
      response.getWriter().print(
          "<html>\n" +
              "<body>\n" +
              "<h1> This is base page to see the Transactions</h1>\n" +
              "<p> You can add transactions by /transactions?user_id=&amount </p>\n" +
              "</body>\n" +
              "</html>");

    } else if (request.getRequestURI().equalsIgnoreCase("/get_transactions")) {
      response.setContentType("application/json; charset=UTF-8");
      List<Transaction> transactions = transactionService.findall();
      response.getWriter().println(objectMapper.writeValueAsString(transactions));
    } else if (request.getRequestURI().equalsIgnoreCase("/get_users")) {
      response.setContentType("application/json; charset=UTF-8");
      List<User> users = userService.findUsers();
      response.getWriter().println(objectMapper.writeValueAsString(users));
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getRequestURI().equalsIgnoreCase("/transactionadd")) {
      String userId = request.getParameter("userId");
      Float amount = Float.valueOf(request.getParameter("amount"));
      Transaction transaction = transactionService.create(userId, amount);
      response.setContentType("application/json; charset=UTF-8");
      String json = objectMapper.writeValueAsString(transaction);
      response.getWriter().println(json);

    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

  }

}
