package com.karthik.myfancypdfinvoices.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.karthik.myfancypdfinvoices.model.Invoice;
import com.karthik.myfancypdfinvoices.service.InvoiceService;
import com.karthik.myfancypdfinvoices.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.myfancypdfinvoices.context.MyFancyPdfInvoicesApplicationConfiguration;

public class MyFancyPdfInvoicesServlet extends HttpServlet {
  private UserService userService;
  private InvoiceService invoiceService;
  private ObjectMapper objectMapper;

  @Override
  public void init() throws ServletException {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
        MyFancyPdfInvoicesApplicationConfiguration.class);
    this.userService = ctx.getBean(UserService.class);
    this.invoiceService = ctx.getBean(InvoiceService.class);
    this.objectMapper = ctx.getBean(ObjectMapper.class);
    // Spring only constructs object once we get same object everywhere
    // @Bean only produces singeltons
    // @scope with value of prototype will give different instances of objects
    // System.out.println(ctx.getBean(UserService.class));
    // System.out.println(ctx.getBean(UserService.class));
    // System.out.println(ctx.getBean(UserService.class));
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    if (request.getRequestURI().equalsIgnoreCase("/")) {
      response.setContentType("text/html; charset=UTF-8");
      response.getWriter().print(
          "<html>\n" +
              "<body>\n" +
              "<h1>Hello World</h1>\n" +
              "<p>This is my very first, embedded Tomcat, HTML Page!</p>\n" +
              "</body>\n" +
              "</html>");
    } else if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
      response.setContentType("application/json; charset=UTF-8");
      List<Invoice> invoices = invoiceService.findAll();
      response.getWriter().print(objectMapper.writeValueAsString(invoices));
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getRequestURI().equalsIgnoreCase("/invoices")) {
      String userId = request.getParameter("user_id");
      Integer amount = Integer.valueOf(request.getParameter("amount"));
      Invoice invoice = invoiceService.create(userId, amount);
      response.setContentType("application/json; charset=UTF-8");
      String json = objectMapper.writeValueAsString(invoice);
      response.getWriter().println(json);
    } else {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
  }
}
