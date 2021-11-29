package com.upt.cti.aplicatiecomandat.DataTypes;

import com.upt.cti.aplicatiecomandat.Enums.Category;

public class Item {

    private String name;
    private int itemId;
    private String provider;
    private Category category;

    public Item(String name, int itemId, String provider, Category category){
        this.name = name;
        this.itemId = itemId;
        this.provider = provider;
        this.category = category;
    }

    public String getItemName(){
        return this.name;
    }

    public int getItemId(){
        return this.itemId;
    }

    public String getProvider(){
        return this.provider;
    }

    public Category getCategory(){
        return this.category;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Item)) return false;
        return ((Item)object).itemId == this.itemId;
    }
}
