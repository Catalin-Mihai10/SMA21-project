package com.upt.cti.aplicatiecomandat.Handlers;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.User;
import com.upt.cti.aplicatiecomandat.Interfaces.Callback;
import com.upt.cti.aplicatiecomandat.Interfaces.IAuthenticationHandler;
import com.upt.cti.aplicatiecomandat.Utilities.HashingSHA256;

public class AuthenticationHandler implements IAuthenticationHandler {
    private final DatabaseReference databaseReference;

    public AuthenticationHandler(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        databaseReference = database.getReference();
    }

    @Override
    public void verifyClientInDatabase(User user,  Callback<Boolean> checkIfUserExist) {
        databaseReference.child(Constants.CHILD_USERS).child(Constants.CHILD_USERNAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    String username = Constants.EMPTY_STRING;

                    if(dataSnapshot.getValue() != null) username = dataSnapshot.getValue().toString();

                    String hashedValueDatabaseUser = HashingSHA256.getEncoding(username);
                    String hashedValueCurrentUser = HashingSHA256.getEncoding(user.getUsername());

                    if(hashedValueCurrentUser.equals(hashedValueDatabaseUser))
                        checkIfUserExist.callback(true);
                    else checkIfUserExist.callback(false);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void  checkIfClientIsInDatabase(User user, Callback<Boolean> userIsInDatabase) {
        databaseReference.child(Constants.CHILD_USERS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    String hashedValueDatabaseUser = Constants.EMPTY_STRING;
                    String hashedValueDatabasePassword = Constants.EMPTY_STRING;
                    String hashedValueCurrentUser;
                    String hashedValueCurrentPassword;

                    User databaseUser = dataSnapshot.getValue(User.class);

                    if(databaseUser != null){
                        hashedValueDatabaseUser = databaseUser.getUsername();
                        hashedValueDatabasePassword = databaseUser.getPassword();
                    }
                    
                    hashedValueCurrentUser = HashingSHA256.getEncoding(user.getUsername());
                    hashedValueCurrentPassword = HashingSHA256.getEncoding(user.getPassword());

                    if(hashedValueCurrentUser.equals(hashedValueDatabaseUser) && hashedValueCurrentPassword.equals(hashedValueDatabasePassword))
                        userIsInDatabase.callback(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void addClientInDatabase(User user, Callback<Boolean> checkIfUserExist) {
        verifyClientInDatabase(user, data -> {
            if(data) checkIfUserExist.callback(false);
            else{
                databaseReference.child(Constants.CHILD_USERS).child(user.getUserID()).child(Constants.CHILD_USERNAME).setValue(HashingSHA256.getEncoding(user.getUsername()));
                databaseReference.child(Constants.CHILD_USERS).child(user.getUserID()).child(Constants.CHILD_PASSWORD).setValue(HashingSHA256.getEncoding(user.getPassword()));
            }
        });
    }
}
