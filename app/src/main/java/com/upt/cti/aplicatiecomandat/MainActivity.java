package com.upt.cti.aplicatiecomandat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Handlers.AuthentificationHandler;
import com.upt.cti.aplicatiecomandat.Modules.ClientModule;

public class MainActivity extends AppCompatActivity {
    private EditText username = (EditText) findViewById(Constants.USERNAME);
    private EditText password = (EditText) findViewById(Constants.PASSWORD);
    private Button register = (Button) findViewById(Constants.REGISTER_BUTTON);
    private Button login = (Button) findViewById(Constants.LOGIN_BUTTON);

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
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });
    }

    public void createLogInListener(Button login, ClientModule client){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client.logIn();
            }
        });
    }
}