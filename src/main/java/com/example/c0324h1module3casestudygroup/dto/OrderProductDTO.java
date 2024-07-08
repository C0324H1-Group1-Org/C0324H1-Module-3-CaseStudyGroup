package com.example.c0324h1module3casestudygroup.dto;

public class OrderProductDTO {
    private String urlImage;
    private String nameProduct;
    private int quantity;
    private float price;

    public OrderProductDTO(String urlImage, String nameProduct, int quantity, float price) {
        this.urlImage = urlImage;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
