package com.upt.cti.aplicatiecomandat.Handlers;

import android.util.Log;

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
                Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Get data from firebase");

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
                Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Get data from firebase");

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

                    Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "user in database:" + hashedValueDatabaseUser);
                    Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "user given:" + hashedValueCurrentUser);

                    Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "user in database:" + hashedValueDatabasePassword);
                    Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "user given:" + hashedValueCurrentPassword);

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

                Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Adding user to database");

                databaseReference.child(Constants.CHILD_USERS).child(user.getUserID()).child(Constants.CHILD_USERNAME).setValue(HashingSHA256.getEncoding(user.getUsername()));
                databaseReference.child(Constants.CHILD_USERS).child(user.getUserID()).child(Constants.CHILD_PASSWORD).setValue(HashingSHA256.getEncoding(user.getPassword()));

                Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "User was added");
            }
        });
    }

    @Override
    public boolean removeClientFromDatabase(User user) {
        DatabaseReference deletingDatabaseReference;

        Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Deleting user from database");

        deletingDatabaseReference = FirebaseDatabase.getInstance(Constants.DATABASE_URL).getReference().child(Constants.CHILD_USERS).child(user.getUserID())
                            .child(Constants.CHILD_USERNAME).child(HashingSHA256.getEncoding(user.getUsername()));
        deletingDatabaseReference.removeValue();
        deletingDatabaseReference = FirebaseDatabase.getInstance(Constants.DATABASE_URL).getReference().child(Constants.CHILD_USERS).child(user.getUserID())
                .child(Constants.CHILD_USERNAME).child(Constants.CHILD_PASSWORD).child(HashingSHA256.getEncoding(user.getPassword()));
        deletingDatabaseReference.removeValue();

        Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "User has been database");

        return true;
    }

    @Override
    public boolean changePassword(String currentPassword, String newPassword) {
        final boolean[] passwordChanged = {false};

        Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Changing password method entered");

        databaseReference.child(Constants.CHILD_USERS).child(Constants.CHILD_PASSWORD).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Get data from firebase");

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Iterating through database");

                    String password = Constants.EMPTY_STRING;

                    if(dataSnapshot.getValue() != null) password = dataSnapshot.getValue().toString();
                    String hashedValueDatabaseUser = HashingSHA256.getEncoding(currentPassword);

                    if(hashedValueDatabaseUser.equals(password)){

                        Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Found match");
                        Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Trying to change password");
                        dataSnapshot.getRef().setValue(HashingSHA256.getEncoding(newPassword));
                        passwordChanged[0] = true;

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Log.d(Constants.AUTHENTICATION_HANDLE_TAG, "Return response");
        return passwordChanged[0];
    }
}
