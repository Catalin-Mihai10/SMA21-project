package com.upt.cti.aplicatiecomandat.DataTypes;

import com.upt.cti.aplicatiecomandat.Utilities.Category;

public class Item {

    private String name;
    private int itemId;
    private double cost;
    private String provider;
    private Category category;

    public Item(){}

    public Item(String name, int itemId, double cost, String provider, Category category){
        this.name = name;
        this.itemId = itemId;
        this.cost = cost;
        this.provider = provider;
        this.category = category;
    }

    public String getItemName(){
        return name;
    }

    public int getItemId(){
        return itemId;
    }

    public double getItemCost(){ return cost;}

    public String getItemProvider(){
        return provider;
    }

    public Category getItemCategory(){
        return category;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Item)) return false;
        return ((Item)object).itemId == this.itemId;
    }
}
