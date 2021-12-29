package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Handlers.AuthentificationHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

public class RegistrationActivity extends AppCompatActivity {
    private EditText username = (EditText) findViewById(Constants.REGISTRATION_USERNAME);
    private EditText password = (EditText) findViewById(Constants.REGISTRATION_PASSWORD);
    private Button submit = (Button) findViewById(Constants.SUBMIT_BUTTON);
    private Button cancel = (Button) findViewById(Constants.CANCEL_BUTTON);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        Log.d(Constants.REGISTRATION_TAG, "RegistrationActivity started");

        ClientModule client = new ClientModule(username.getText().toString(),  password.getText().toString());

        createSubmitListener(submit, client);

    }

    public void createSubmitListener(Button submit, ClientModule client){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.register();
            }
        });
    }


}
