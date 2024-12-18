package com.karthik.myfancypdfinvoices.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.myfancypdfinvoices.dto.InvoiceDto;
import com.karthik.myfancypdfinvoices.model.Invoice;
import com.karthik.myfancypdfinvoices.service.InvoiceService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@RestController
// This @validated annotation is required when we are making checks direclty on
// request params varibles to work
@Validated
public class InvoicesController {
  // INstacne of invoice service class
  private final InvoiceService invoiceService;

  public InvoicesController(InvoiceService invoiceService) {
    this.invoiceService = invoiceService;
  }

  // @GetMapping(value = "/html", produces = "text/html")
  // public String startup() {
  // return """
  // <!DOCTYPE html>
  // <html>
  // <head>
  // <title>Hello World</title>
  // </head>
  // <body>
  // <h1>Hello World</h1>
  // <p>This is my very first, embedded Tomcat, HTML Page!</p>
  // </body>
  // </html>
  // """;
  // }

  @GetMapping("/invoices")
  public List<Invoice> invoices() {
    return invoiceService.findAll();
  }
  // If we are using DTO's and valid annotations in DTO class
  // we can use class like below
  // @PostMapping("/invoices")
  // public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
  // return invoiceService.create(invoiceDto.getuserId(), invoiceDto.getAmount());
  // }

  // If we are usign @requestparams we can do like below to check if valid or not
  @PostMapping("/invoices")
  public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId,
      @RequestParam("amount") @Min(10) @Max(50) Integer amount) {
    return invoiceService.create(userId, amount);
  }
}
