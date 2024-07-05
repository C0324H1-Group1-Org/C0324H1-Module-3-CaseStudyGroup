package com.example.c0324h1module3casestudygroup.models;

public class Product {
    private int id;
    private String name;
    private int price;
    private String description;
    private int stock;
    private String UrlImage;
    private int idSubType;

    public Product() {
    }

    public Product(int id, String name, int price, String description, int stock, String urlImage, int idSubType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        UrlImage = urlImage;
        this.idSubType = idSubType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }

    public int getIdSubType() {
        return idSubType;
    }

    public void setIdSubType(int idSubType) {
        this.idSubType = idSubType;
    }
}
