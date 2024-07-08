package com.example.c0324h1module3casestudygroup.dto;

import java.util.Date;

public class OrderDetailDTO {
    private String urlImage;
    private String name;
    private int quantity;
    private long price;
    private Date date;

    public OrderDetailDTO(String urlImage, String name, int quantity, long price, Date date) {
        this.urlImage = urlImage;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
