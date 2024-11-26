package com.karthik.myfancypdfinvoices.model;

import java.util.UUID;

public class Invoice {
  private String id, userId, pdfUrl;
  private Integer amount;

  public Invoice(String userId, String pdfUrl, Integer amount) {
    this.id = UUID.randomUUID().toString();
    this.userId = userId;
    this.pdfUrl = pdfUrl;
    this.amount = amount;
  }

  // Getters and Setters
  public void setId(String id) {
    this.id = id;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setPdfUrl(String pdfUrl) {
    this.pdfUrl = pdfUrl;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getId() {
    return id;
  }

  public String getUserId() {
    return userId;
  }

  public String getPdfUrl() {
    return pdfUrl;
  }

  public Integer getAmount() {
    return amount;
  }

}
