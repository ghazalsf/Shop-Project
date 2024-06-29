package org.example;
public class Product {
    private int price;
    private double score;
    private int stock;
    private String name;
    private String category;
    private String description;
    String pictureAddress;

    public Product(int price,double score,int stock,String name,String description, String category, String pictureAddress){
        this.price=price;
        this.score=score;
        this.stock=stock;
        this.name=name;
        this.description=description;
        this.category = category;
        this.pictureAddress = pictureAddress;
    }

    public void setPrice(int price){
        this.price = price;
    }
    public void setScore(double score){
        this.score = score;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCategory(String category) {this.category = category;}
    public void setPictureAddress(String pictureAddress){this.pictureAddress = pictureAddress;}
    public int getPrice(){
        return this.price;
    }
    public double getScore(){
        return this.score;
    }
    public int getStock(){
        return this.stock;
    }
    public String getName(){
        return this.name;
    }
    public  String getDescription(){
        return this.description;
    }
    public String getCategory() {
        return this.category;
    }
    public String getPictureAddress(){return this.pictureAddress;}
}
