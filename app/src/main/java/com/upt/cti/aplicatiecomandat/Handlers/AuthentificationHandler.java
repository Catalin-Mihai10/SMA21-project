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
import com.upt.cti.aplicatiecomandat.Interfaces.IAuthentificationHandler;
import com.upt.cti.aplicatiecomandat.Utilities.HashingSHA256;

public class AuthentificationHandler implements IAuthentificationHandler{
    private DatabaseReference databaseReference;
    private DatabaseReference deletetingDatabaseReference;

    public AuthentificationHandler(){
        FirebaseDatabase database = FirebaseDatabase.getInstance(Constants.DATABASE_URL);
        databaseReference = database.getReference();
    }

    @Override
    public boolean verifyClientInDatabase(User user) {
        final boolean[] userAlreadyExist = {false};

        databaseReference.child(Constants.CHILD_USERS).child(Constants.CHILD_USERNAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Get data from firebase");

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    String username = dataSnapshot.getValue().toString();
                    String hashedValueDatabaseUser = HashingSHA256.getEncoding(username);
                    String hasedValueCurrentUser = HashingSHA256.getEncoding(user.getUsername());

                    if(hasedValueCurrentUser.equals(hashedValueDatabaseUser)) userAlreadyExist[0] = true;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return userAlreadyExist[0];
    }

    @Override
    public boolean authentificateClientInDatabase(User user) {
        final boolean[] userIsInDatabase = {false};
        //final boolean[] passwordIsCorrect = {false};

        databaseReference.child(Constants.CHILD_USERS).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Get data from firebase");

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    User databaseUser = dataSnapshot.getValue(User.class);
                    String hashedValueDatabaseUser = HashingSHA256.getEncoding(databaseUser.getUsername());
                    String hasedValueCurrentUser = HashingSHA256.getEncoding(user.getUsername());

                    String hashedValueDatabasePassword = HashingSHA256.getEncoding(databaseUser.getPassword());
                    String hasedValueCurrentPassword = HashingSHA256.getEncoding(user.getPassword());

                    Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "user in database:" + hashedValueDatabaseUser);
                    Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "user given:" + hasedValueCurrentUser);

                    if(hasedValueCurrentUser.equalsIgnoreCase(hashedValueDatabaseUser) && hasedValueCurrentPassword.equalsIgnoreCase(hashedValueDatabasePassword))
                        userIsInDatabase[0] = true;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        databaseReference.child(Constants.CHILD_USERS).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Get data from firebase");
//
//                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    String password = dataSnapshot.getValue().toString();
//                    String hashedValueDatabasePassword = HashingSHA256.getEncoding(password);
//                    String hasedValueCurrentPassword = HashingSHA256.getEncoding(user.getPassword());
//
//                    Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "password in database:" + hashedValueDatabasePassword);
//                    Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "password given:" + hasedValueCurrentPassword);
//
//                    if(hasedValueCurrentPassword.equals(hashedValueDatabasePassword)) passwordIsCorrect[0] = true;
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        return userIsInDatabase[0];
    }

    @Override
    public boolean addClientInDatabase(User user) {
        if(verifyClientInDatabase(user)) return false;

        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Adding user to database");

        databaseReference.child(Constants.CHILD_USERS).child(user.getUserID()).child(Constants.CHILD_USERNAME).setValue(HashingSHA256.getEncoding(user.getUsername()));
        databaseReference.child(Constants.CHILD_USERS).child(user.getUserID()).child(Constants.CHILD_PASSWORD).setValue(HashingSHA256.getEncoding(user.getPassword()));

        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "User was added");

        return true;
    }

    @Override
    public boolean removeClientFromDatabase(User user) {

        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Deleting user from database");

        deletetingDatabaseReference = FirebaseDatabase.getInstance(Constants.DATABASE_URL).getReference().child(Constants.CHILD_USERS).child(user.getUserID())
                            .child(Constants.CHILD_USERNAME).child(HashingSHA256.getEncoding(user.getUsername()));
        deletetingDatabaseReference.removeValue();
        deletetingDatabaseReference = FirebaseDatabase.getInstance(Constants.DATABASE_URL).getReference().child(Constants.CHILD_USERS).child(user.getUserID())
                .child(Constants.CHILD_USERNAME).child(Constants.CHILD_PASSWORD).child(HashingSHA256.getEncoding(user.getPassword()));
        deletetingDatabaseReference.removeValue();

        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "User has been database");

        return true;
    }

    @Override
    public void requestDataFromDatabase() {}

    @Override
    public boolean changePassword(String currentPassword, String newPassword) {
        final boolean[] passwordChanged = {false};

        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Changing password method entered");

        databaseReference.child(Constants.CHILD_USERS).child(Constants.CHILD_PASSWORD).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Get data from firebase");

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Iterating thru database");

                    String password = dataSnapshot.getValue().toString();
                    String hashedValueDatabaseUser = HashingSHA256.getEncoding(currentPassword);
                    if(hashedValueDatabaseUser.equals(password)){
                        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Found match");
                        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Trying to change password");
                        dataSnapshot.getRef().setValue(HashingSHA256.getEncoding(newPassword));
                        passwordChanged[0] = true;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Log.d(Constants.AUTHENTIFICATION_HANDLE_TAG, "Return response");
        return passwordChanged[0];
    }
}
