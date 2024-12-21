package com.karthik.myfancypdfinvoices_springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

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