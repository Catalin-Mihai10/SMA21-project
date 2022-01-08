package com.upt.cti.aplicatiecomandat.DataTypes;

import com.upt.cti.aplicatiecomandat.Utilities.Category;

import java.util.Random;

public class Item {

    private String name;
    private int itemId;
    private double cost;
    private String provider;
    private Category category;
    private int quantity = 0;

    public Item(){}

    public Item(String name, double cost, String provider, Category category){
        this.name = name;
        this.itemId = generateItemID();
        this.cost = cost;
        this.provider = provider;
        this.category = category;
    }

    public String getItemName(){
        return name;
    }

    public String getItemId(){ return String.valueOf(itemId); }

    public double getItemCost(){ return cost;}

    public String getItemProvider(){
        return provider;
    }

    public Category getItemCategory(){
        return category;
    }

    public void setItemId(int itemID){ this.itemId = itemID; }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Item)) return false;
        return ((Item)object).itemId == this.itemId;
    }

    private int generateItemID(){
        Random rnd = new Random();
        return rnd.nextInt(999999);
    }

}
