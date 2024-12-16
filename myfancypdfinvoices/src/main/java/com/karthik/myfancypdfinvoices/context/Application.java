package com.karthik.myfancypdfinvoices.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karthik.myfancypdfinvoices.service.InvoiceService;
import com.karthik.myfancypdfinvoices.service.UserService;

// We inject these object whenver we need them in the services 

public class Application {
  public static final UserService userService = new UserService();
  // User service is wired to invoiceservice using its constructor
  public static final InvoiceService invoiceService = new InvoiceService(userService);
  public static final ObjectMapper objectMapper = new ObjectMapper();
}
