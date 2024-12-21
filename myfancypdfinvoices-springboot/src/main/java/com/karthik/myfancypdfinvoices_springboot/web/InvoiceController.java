package com.karthik.myfancypdfinvoices_springboot.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.myfancypdfinvoices_springboot.dto.InvoiceDto;
import com.karthik.myfancypdfinvoices_springboot.model.Invoice;
import com.karthik.myfancypdfinvoices_springboot.service.InvoiceService;

import jakarta.validation.Valid;

@RestController
public class InvoiceController {

  private final InvoiceService invoiceService;

  public InvoiceController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
  }

  @GetMapping("/invoices")
  public List<Invoice> invoices() {
    return invoiceService.findall();
  }

  @PostMapping("/invoices")
  public Invoice creatInvoice(@Valid @RequestBody InvoiceDto invoiceDto) {
    return invoiceService.create(invoiceDto.getuserId(), invoiceDto.getAmount());
  }

}
