package com.pontic_studio.myproperty.Models;

public class Property {
    String propertyName;
    String ownerName;
    String adress;
    String price;
    String status;
    boolean type;
    String description;

    public Property(String propertyName, String ownerName, String adress, String price, String status, boolean type, String description) {
        this.propertyName = propertyName;
        this.ownerName = ownerName;
        this.adress = adress;
        this.price = price;
        this.status = status;
        this.type = type;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

}
