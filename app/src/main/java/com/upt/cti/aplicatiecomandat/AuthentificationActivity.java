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

public class AuthentificationActivity extends AppCompatActivity {
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

        createRegistrationListener();
        createLogInListener();
    }

    public void createRegistrationListener(){
        register.setOnClickListener(view -> startActivity(new Intent(AuthentificationActivity.this, RegistrationActivity.class)));
    }

    public void createLogInListener(){
        login.setOnClickListener(view -> {

            ClientModule client = new ClientModule(username.getText().toString(), password.getText().toString());

            if(client.logIn()) startActivity(new Intent(AuthentificationActivity.this, MainActivity.class));
            else Log.d(Constants.AUTHENTIFICATION_TAG, "Username or password wrong!");

        });
    }
}
