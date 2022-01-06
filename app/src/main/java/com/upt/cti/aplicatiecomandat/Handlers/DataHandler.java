package com.upt.cti.aplicatiecomandat.Handlers;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.DataTypes.PurchaseInformation;
import com.upt.cti.aplicatiecomandat.DataTypes.Cart;

import java.util.Random;

public class DataHandler {
    private final int purchaseID;

    public DataHandler(){
        purchaseID = generateUserID();
    }

    private int generateUserID(){
        Random rnd = new Random();
        return rnd.nextInt(999999);
    }

    public boolean processItemData(Cart cart, PurchaseInformation purchaseInformation) {
        return writeDataToDatabase(cart, purchaseInformation);
    }

    private boolean writeDataToDatabase(Cart cart, PurchaseInformation purchaseInformation){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        DatabaseReference databaseReference = database.getReference();
        boolean writeOperation = true;

        try {
            databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID)).child("user").setValue(purchaseInformation.getUser());
            databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID)).child("phone").setValue(purchaseInformation.getPhone());
            databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID)).child("address").setValue(purchaseInformation.getAddress());
            databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID)).child("country").setValue(purchaseInformation.getCountry());
            databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID)).child("city").setValue(purchaseInformation.getCity());

            for (Item item : cart.getCart()) {
                databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID))
                        .child(item.getItemId()).child("name").setValue(item.getItemName());
                databaseReference.child(Constants.CHILD_COMMAND).child(String.valueOf(purchaseID))
                        .child(item.getItemId()).child("cost").setValue(item.getItemCost());
            }
        }catch (Exception e){
            writeOperation = false;
        }
        return writeOperation;
    }
}
