package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

public class RegistrationActivity extends AppCompatActivity {
    private final EditText username = findViewById(Constants.REGISTRATION_USERNAME);
    private final EditText password = findViewById(Constants.REGISTRATION_PASSWORD);
    private final Button submit = findViewById(Constants.SUBMIT_BUTTON);
    private final Button cancel = findViewById(Constants.CANCEL_BUTTON);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        Log.d(Constants.REGISTRATION_TAG, "RegistrationActivity started");

        ClientModule client = new ClientModule(username.getText().toString(),  password.getText().toString());

        createSubmitListener(client);
        createCancelListener();
    }

    public void createSubmitListener(ClientModule client){
        submit.setOnClickListener(view -> {

            if(client.register()) startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            else Log.d(Constants.REGISTRATION_TAG, "Failed registration!");

        });
    }

    public void createCancelListener(){
        cancel.setOnClickListener(view -> {

            Log.d(Constants.REGISTRATION_TAG, "Cancel registration");
            username.setText(Constants.EMPTY_STRING);
            password.setText(Constants.EMPTY_STRING);

            Log.d(Constants.REGISTRATION_TAG, "return to MainActivity");
            finish();

        });
    }

}
