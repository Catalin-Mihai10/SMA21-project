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
    private final EditText username = findViewById(Constants.USERNAME);
    private final EditText password = findViewById(Constants.PASSWORD);
    private final Button register = findViewById(Constants.REGISTER_BUTTON);
    private final Button login = findViewById(Constants.LOGIN_BUTTON);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        ClientModule client = new ClientModule(username.getText().toString(), password.getText().toString());

        createRegistrationListener(register);
        createLogInListener(login, client);
    }

    public void createRegistrationListener(Button register){
        register.setOnClickListener(view -> startActivity(new Intent(AuthentificationActivity.this, RegistrationActivity.class)));
    }

    public void createLogInListener(Button login, ClientModule client){
        login.setOnClickListener(view -> {

            if(client.logIn()) startActivity(new Intent(AuthentificationActivity.this, MainActivity.class));
            else Log.d(Constants.AUTHENTIFICATION_TAG, "Username or password wrong!");

        });
    }
}
