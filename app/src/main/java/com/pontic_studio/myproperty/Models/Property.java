package com.pontic_studio.myproperty.Models;

public class Property {

		int ID;
    String propertyName;
    String ownerName;
    String address;
    String price;
    String status;
    String type;
    String description;

    public Property(int id, String propertyName, String ownerName, String adress, String price, String status, String type, String description) {
				this.ID = id;
        this.propertyName = propertyName;
        this.ownerName = ownerName;
        this.address = adress;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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

    public String isType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
