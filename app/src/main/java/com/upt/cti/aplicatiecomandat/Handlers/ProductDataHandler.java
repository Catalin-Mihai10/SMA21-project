package com.upt.cti.aplicatiecomandat.Handlers;

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
import com.upt.cti.aplicatiecomandat.Utilities.Category;

import java.util.ArrayList;
import java.util.List;

public class ProductDataHandler {
    private final DatabaseReference databaseReference;


    public ProductDataHandler(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        databaseReference = database.getReference();
    }

    public List<Item> loadProductsFromDataBase(Category category){
        List<Item> returnedItemsList = new ArrayList<>();

        databaseReference.child(Constants.CHILD_PROVIDERS).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                try{
                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                        Item item = null;

                        if(dataSnapshot != null) item = dataSnapshot.getValue(Item.class);

                        assert item != null;
                        if(String.valueOf(item.getItemCategory()).equals(String.valueOf(category))) returnedItemsList.add(item);
                    }
                }catch(Exception e){
                    Log.d(Constants.PRODUCT_DATA_HANDLER_TAG, "ERROR: at loading items from database!");
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}

            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        });


        return returnedItemsList;
    }
}
