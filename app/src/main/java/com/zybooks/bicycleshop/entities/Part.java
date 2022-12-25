package com.zybooks.bicycleshop.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Part")
public class Part {
    @PrimaryKey(autoGenerate = true)
    private int partID;
    private String partName;
    private double partPrice;
    private int productID;


    public Part(int partID, String partName, double partPrice, int productID) {
        this.partID = partID;
        this.partName = partName;
        this.partPrice = partPrice;
        this.productID = productID;
    }

    public Part() {
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPartID() {
        return partID;
    }

    public String getPartName() {
        return partName;
    }

    public double getPartPrice() {
        return partPrice;
    }

    public int getProductID() {
        return productID;
    }
}
