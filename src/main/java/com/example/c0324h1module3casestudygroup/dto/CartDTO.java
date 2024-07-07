package com.example.c0324h1module3casestudygroup.dto;

public class CartDTO {
    private int idCart;
    private String urlImage;
    private int idProduct;
    private String nameProduct;
    private Float price;
    private int quantity;
    private float priceQuantity;

    public int getIdCart() {
        return idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPriceQuantity() {
        return priceQuantity;
    }

    public void setPriceQuantity(float priceQuantity) {
        this.priceQuantity = priceQuantity;
    }

    public CartDTO(String urlImage, String nameProduct, Float price, int quantity, float priceQuantity) {
        this.urlImage = urlImage;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.priceQuantity = priceQuantity;
    }

    public CartDTO(int idCart, String urlImage, String nameProduct, Float price, int quantity, float priceQuantity) {
        this.idCart = idCart;
        this.urlImage = urlImage;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.priceQuantity = priceQuantity;
    }

    public CartDTO(int idCart, String urlImage, int idProduct, String nameProduct, Float price, int quantity, float priceQuantity) {
        this.idCart = idCart;
        this.urlImage = urlImage;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantity = quantity;
        this.priceQuantity = priceQuantity;
    }
}
