package com.karthik.simplebank.web;

import java.io.IOException;
import java.util.List;

import com.karthik.simplebank.context.Application;
import com.karthik.simplebank.model.Transaction;
import com.karthik.simplebank.model.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SimpleBankServlet extends HttpServlet {
  // private TransactionService transactionService = new TransactionService();
  // private ObjectMapper objectMapper = new ObjectMapper();

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
      List<Transaction> transactions = Application.transactionService.findall();
      response.getWriter().println(Application.objectMapper.writeValueAsString(transactions));
    } else if (request.getRequestURI().equalsIgnoreCase("/get_users")) {
      response.setContentType("application/json; charset=UTF-8");
      List<User> users = Application.userService.findUsers();
      response.getWriter().println(Application.objectMapper.writeValueAsString(users));
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getRequestURI().equalsIgnoreCase("/transactionadd")) {
      String userId = request.getParameter("userId");
      Float amount = Float.valueOf(request.getParameter("amount"));
      Transaction transaction = Application.transactionService.create(userId, amount);
      response.setContentType("application/json; charset=UTF-8");
      String json = Application.objectMapper.writeValueAsString(transaction);
      response.getWriter().println(json);

    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }

  }

}
