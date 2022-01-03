package com.upt.cti.aplicatiecomandat.Test;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Utilities.Category;

import java.util.ArrayList;
import java.util.List;

public class CreateProductsAndStoreThem {
    List<Item> itemList;

    public CreateProductsAndStoreThem(){
        itemList = new ArrayList<>();
    }

    public void initialize(){
        createAndStoreItems();
        writeItemsToDatabase();
    }

    public void createAndStoreItems(){
        Item item1 = new Item("Mandarine", 10.99, "Mandarinu Ionel", Category.OFFERS);
        Item item2 = new Item("Cotlet de porc", 19.99, "Nelu", Category.ANIMAL_PRODUCTS);
        Item item3 = new Item("Lapte", 5.00, "Alexandra", Category.LACTATE);
        Item item4 = new Item("Portocale", 2.50, "Vasile", Category.FRUITS);
        Item item5 = new Item("Faina", 1.50, "Mircea", Category.CEREALS);
        Item item6 = new Item("Ulei de floarea soarelui", 7.79, "Uleiosu Matei", Category.OILS);

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
    }

    public void writeItemsToDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        DatabaseReference databaseReference = database.getReference();

        for(Item item : itemList)
            databaseReference.child(Constants.CHILD_PROVIDERS).child(item.getItemId()).setValue(item);
    }
}
