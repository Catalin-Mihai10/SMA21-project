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
    private EditText username;
    private EditText password;
    private Button submit;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        username = findViewById(Constants.REGISTRATION_USERNAME);
        password = findViewById(Constants.REGISTRATION_PASSWORD);
        submit = findViewById(Constants.SUBMIT_BUTTON);
        cancel = findViewById(Constants.CANCEL_BUTTON);

        Log.d(Constants.REGISTRATION_TAG, "RegistrationActivity started");

        createSubmitListener();
        createCancelListener();
    }

    public void createSubmitListener(){
        submit.setOnClickListener(view -> {

            ClientModule client = new ClientModule(username.getText().toString(),  password.getText().toString());

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
