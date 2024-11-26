package com.karthik.myfancypdfinvoices.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.karthik.myfancypdfinvoices.model.Invoice;

public class InvoiceService {
  List<Invoice> invoices = new CopyOnWriteArrayList<>();

  public List<Invoice> findAll() {
    return invoices;
  }

  public Invoice create(String userId, Integer amount) {
    Invoice invoice = new Invoice(userId, "https://www.randompdf.edu/images/default/sample.pdf", amount);
    invoices.add(invoice);
    return invoice;
  }
}
