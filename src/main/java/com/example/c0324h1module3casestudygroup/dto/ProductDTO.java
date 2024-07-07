package com.example.c0324h1module3casestudygroup.dto;

public class ProductDTO {
    private int id;
    private String UrlImage;
    private String name;
    private long price;


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
