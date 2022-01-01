package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

public class AuthenticationActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button register;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);

        username = findViewById(Constants.USERNAME);
        password = findViewById(Constants.PASSWORD);
        register = findViewById(Constants.REGISTER_BUTTON);
        login = findViewById(Constants.LOGIN_BUTTON);

        initializeFields();

        createRegistrationListener();
        createLogInListener();
    }

    public void initializeFields(){
        username.setText(Constants.EMPTY_STRING);
        password.setText(Constants.EMPTY_STRING);
    }

    public void createRegistrationListener(){
        register.setOnClickListener(view -> startActivity(new Intent(AuthenticationActivity.this, RegistrationActivity.class)));
    }

    public void createLogInListener(){
        login.setOnClickListener(view -> {

            ClientModule client = new ClientModule(username.getText().toString(), password.getText().toString());

            client.logIn(data -> {
                if(data) startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
                else{
                    Toast.makeText(AuthenticationActivity.this, "Username or password wrong!", Toast.LENGTH_SHORT).show();
                    Log.d(Constants.AUTHENTICATION_TAG, "Username or password wrong!");
                }
            });
        });
    }
}