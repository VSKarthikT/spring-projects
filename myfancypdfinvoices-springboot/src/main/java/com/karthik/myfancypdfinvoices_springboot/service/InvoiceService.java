package com.karthik.myfancypdfinvoices_springboot.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.karthik.myfancypdfinvoices_springboot.model.Invoice;
import com.karthik.myfancypdfinvoices_springboot.model.User;

import jakarta.annotation.PostConstruct;

@Component
public class InvoiceService {
  public List<Invoice> invoices = new CopyOnWriteArrayList<>();
  private final UserService userService;
  private final String cdnUrl;

  public InvoiceService(UserService userService, @Value("${cdn.url}") String cdnUrl) {
    this.userService = userService;
    this.cdnUrl = cdnUrl;
  }

  @PostConstruct
  public void init() {
    System.out.println("Fetching pdf templates for AWS");
  }

  @PostConstruct
  public void shutdown() {
    System.out.println("Deleting downloaded tmplates");
  }

  public List<Invoice> findall() {
    return invoices;
  }

  public Invoice create(String userId, Integer amount) {
    User user = userService.findById(userId);
    if (user == null) {
      throw new IllegalStateException();
    }
    Invoice invoice = new Invoice(userId, amount, cdnUrl + "/images/default/sample");
    invoices.add(invoice);
    return invoice;
  }
}
