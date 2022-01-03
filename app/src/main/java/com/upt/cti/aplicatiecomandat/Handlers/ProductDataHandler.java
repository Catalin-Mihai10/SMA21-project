package com.upt.cti.aplicatiecomandat.Handlers;

import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Interfaces.Callback;
import com.upt.cti.aplicatiecomandat.Utilities.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDataHandler {
    private final DatabaseReference databaseReference;


    public ProductDataHandler(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        databaseReference = database.getReference();
    }

    public List<Item> loadProductsFromDataBase(Category category, Callback<Boolean> dataIsLoaded){
        List<Item> returnedItemsList = new ArrayList<>();
        Log.d(Constants.PRODUCT_DATA_HANDLER_TAG, "category:" + category.toString());

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                try{
                    Log.d(Constants.PRODUCT_DATA_HANDLER_TAG, "iteram");
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                        Double d = dataSnapshot.child("itemCost").getValue(Double.class);
                        double cost = 0.00;
                        if(d != null) cost = d;

                        String databaseItemCategory = dataSnapshot.child("itemCategory").getValue(String.class);
                        if(databaseItemCategory == null) databaseItemCategory = "";

                        Item item = new Item(dataSnapshot.child("itemName").getValue(String.class),
                                             cost,
                                             dataSnapshot.child("itemProvider").getValue(String.class),
                                             Category.stringToCategory(databaseItemCategory));

                        Integer databaseId = dataSnapshot.child("itemID").getValue(Integer.class);
                        int itemId = 0;
                        if(databaseId != null) itemId = databaseId;
                        item.setItemId(itemId);

                        if(String.valueOf(item.getItemCategory()).equals(String.valueOf(category))){
                            returnedItemsList.add(item);
                            Log.d(Constants.PRODUCT_DATA_HANDLER_TAG, "adaugam item-ul in lista");
                        }

                        dataIsLoaded.callback(true);
                    }
                }catch(Exception e){
                    Log.d(Constants.PRODUCT_DATA_HANDLER_TAG, "ERROR: in " + Constants.PRODUCT_DATA_HANDLER_TAG + " at loading items from database!");
                    e.printStackTrace();
                    dataIsLoaded.callback(false);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return returnedItemsList;
    }
}
