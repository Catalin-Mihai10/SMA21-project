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
        itemList.add(new Item("Mandarine", 10.99, "Mandarinu Ionel", Category.OFFERS));
        itemList.add(new Item("Ulei", 5.54, "Haded", Category.OFFERS));
        itemList.add(new Item("Brânză", 15.64, "Lolui", Category.OFFERS));
        itemList.add(new Item("Ou", 0.33, "Nea Gică", Category.OFFERS));
        itemList.add(new Item("Piept pui", 12.50, "Bibi", Category.OFFERS));

        itemList.add(new Item("Cotlet de porc", 19.99, "Nelu", Category.ANIMAL_PRODUCTS));
        itemList.add(new Item("Spată", 25.00, "Gelu", Category.ANIMAL_PRODUCTS));
        itemList.add(new Item("Scăricică", 10.30, "Dorelu", Category.ANIMAL_PRODUCTS));
        itemList.add(new Item("Aripi de pui", 3.99, "Mateiu", Category.ANIMAL_PRODUCTS));
        itemList.add(new Item("Piept vită", 45.50, "Liceu", Category.ANIMAL_PRODUCTS));

        itemList.add(new Item("Lapte", 5.00, "Alexandra", Category.LACTATE));
        itemList.add(new Item("Branză de vacă", 5.00, "Marius", Category.LACTATE));
        itemList.add(new Item("Lapte de capră", 5.00, "Dolică", Category.LACTATE));

        itemList.add(new Item("Portocale", 2.50, "Vasile", Category.FRUITS));
        itemList.add(new Item("Căpșuni", 6.99, "Gogu", Category.FRUITS));
        itemList.add(new Item("Struguri", 8.80, "Neacșu", Category.FRUITS));
        itemList.add(new Item("Banane", 1.50, "Morir", Category.FRUITS));
        itemList.add(new Item("Mere", 1.00, "Gabi", Category.FRUITS));

        itemList.add(new Item("Făină de grâu", 1.50, "Mircea", Category.CEREALS));
        itemList.add(new Item("Făină de mălai", 1.50, "Mircea", Category.CEREALS));

        itemList.add(new Item("Ulei", 7.79, "Uleiosu Matei", Category.OILS));
        itemList.add(new Item("Ulei de rapiță", 7.79, "Dincă", Category.OILS));
        itemList.add(new Item("Ulei de palmier", 7.79, "Maricica", Category.OILS));
    }

    public void writeItemsToDatabase(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        DatabaseReference databaseReference = database.getReference();

        for(Item item : itemList)
            databaseReference.child(Constants.CHILD_PROVIDERS).child(item.getItemId()).setValue(item);
    }
}
