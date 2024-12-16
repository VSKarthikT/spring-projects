package com.karthik.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.karthik.myfancypdfinvoices.model.Invoice;
import com.karthik.myfancypdfinvoices.model.User;

public class InvoiceService {
  // COnstructor Injection user service
  private final UserService userService;

  public InvoiceService(UserService userService) {
    this.userService = userService;

  }

  List<Invoice> invoices = new CopyOnWriteArrayList<>();

  public List<Invoice> findAll() {
    return invoices;
  }

  public Invoice create(String userId, Integer amount) {
    User user = userService.findById(userId);
    if (user == null) {
      throw new IllegalStateException();
    }
    Invoice invoice = new Invoice(userId, "https://www.randompdf.edu/images/default/sample.pdf", amount);
    invoices.add(invoice);
    return invoice;
  }
}
