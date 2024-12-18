package com.karthik.myfancypdfinvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/* 
 * If we want to post these kind of requests we need
 * Data Transfer Objects defined (DTO's) which is usefull
 * for tranferring data from frontend to backend
 */
// POST http://localhost:8080/invoices
// Content-Type: application/json
// ####
// {
//   "amount": 5000,
//   "user_id": "helene"
// }
public class InvoiceDto {

  @JsonProperty("user_id")
  @NotBlank
  private String userId;

  @Min(10)
  @Max(100)
  private Integer amount;

  public String getuserId() {
    return userId;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setuserId(String userId) {
    this.userId = userId;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }
}
