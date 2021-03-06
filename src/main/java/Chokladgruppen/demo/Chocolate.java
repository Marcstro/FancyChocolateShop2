package Chokladgruppen.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chocolate {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long chocolateId;
    private String name;
    private double price;
    private String description;
    private String brand;
    private int inStock;
    private int amount;
    private String inStockMessage;
    private boolean showPopUp;
    private String pictureName;
    private String smallPictureName;

    public Chocolate() {
    }

    public Chocolate(String name, double price, String description, String brand, int inStock, int amount, String inStockMessage, boolean showPopUp, String pictureName, String smallPictureName) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.inStock = inStock;
        this.amount = amount;
        this.inStockMessage = inStockMessage;
        this.showPopUp = showPopUp;
        this.pictureName = pictureName;
        this.smallPictureName = smallPictureName;
    }

    public Long getChocolateId() {
        return chocolateId;
    }

    public void setChocolateId(Long chocolateId) {
        this.chocolateId = chocolateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInStockMessage() {
        return inStockMessage;
    }

    public void setInStockMessage(String inStockMessage) {
        this.inStockMessage = inStockMessage;
    }

    public boolean isShowPopUp() {
        return showPopUp;
    }

    public void setShowPopUp(boolean showPopUp) {
        this.showPopUp = showPopUp;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getSmallPictureName() {
        return smallPictureName;
    }

    public void setSmallPictureName(String smallPictureName) {
        this.smallPictureName = smallPictureName;
    }

    
    
    @Override
    public String toString() {
        return "Chocolate{" + "chocolateId=" + chocolateId + ", name=" + name + ", price=" + price + ", description=" + description + ", brand=" + brand + ", inStock=" + inStock + ", amount=" + amount + ", inStockMessage=" + inStockMessage + ", showPopUp=" + showPopUp + ", pictureName=" + pictureName + '}';
    }

    
    
    
    
    
    
    

}
