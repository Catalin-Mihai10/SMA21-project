package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
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
        setContentView(Constants.AUTHENTICATION_LAYOUT);

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
            if(!username.getText().toString().equals(Constants.EMPTY_STRING) &&  !password.getText().toString().equals(Constants.EMPTY_STRING)){
                ClientModule client = new ClientModule(username.getText().toString(), password.getText().toString());

                client.logIn(data -> {
                    if(data) {
                        CommandHandler.saveUserInternally(client.getNewUser());
                        startActivity(new Intent(AuthenticationActivity.this, MainActivity.class));
                    }
                    else Toast.makeText(AuthenticationActivity.this, Constants.USER_WARNING_MESSAGE, Toast.LENGTH_SHORT).show();

                });
            } else Toast.makeText(AuthenticationActivity.this, Constants.EMPTY_FIELDS_WARNING_MESSAGE, Toast.LENGTH_SHORT).show();
        });
    }

}
