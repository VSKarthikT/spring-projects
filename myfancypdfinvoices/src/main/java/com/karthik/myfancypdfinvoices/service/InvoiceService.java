package com.karthik.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.karthik.myfancypdfinvoices.model.Invoice;
import com.karthik.myfancypdfinvoices.model.User;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class InvoiceService {
  // @PostConstruct
  // public void init() {
  // System.out.println("just after bean created do something");
  // }

  // @PreDestroy
  // public void shut() {
  // System.out.println("before destroying bean");
  // }

  // Constructor Injection user service
  List<Invoice> invoices = new CopyOnWriteArrayList<>();

  // Field injection
  // @Autowired
  private final UserService userService;
  private final String cdnUrl;
  // We can comment out below injection when we are using autowired annotation
  // because spring knows where this needs to injected

  // For reading properties file
  public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
    this.userService = userService;
    this.cdnUrl = cdnUrl;
  }

  public List<Invoice> findAll() {
    return invoices;
  }

  public Invoice create(String userId, Integer amount) {
    User user = userService.findById(userId);
    if (user == null) {
      throw new IllegalStateException();
    }
    Invoice invoice = new Invoice(userId, cdnUrl + "https://www.randompdf.edu/images/default/sample.pdf", amount);
    invoices.add(invoice);
    return invoice;
  }

  // Setter Injection
  // @Autowired
  // public void setUserService(UserService userService) {
  // this.userService = userService;
  // }
}
