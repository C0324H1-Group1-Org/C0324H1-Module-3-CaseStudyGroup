package com.example.c0324h1module3casestudygroup.dto;

import java.util.Date;

public class ProductDTO {
    private int id;
    private String UrlImage;
    private String name;
    private long price;

    private int quantity;
    private Date date;

    public ProductDTO(String urlImage, String name, int quantity, long price) {
        UrlImage = urlImage;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public ProductDTO(){

    }
    public ProductDTO(int id, String UrlImage, String name, long price ){
        this.id = id;
        this.UrlImage = UrlImage;
        this.name =name;
        this.price = price;
    }
}
