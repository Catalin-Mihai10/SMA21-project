package com.upt.cti.aplicatiecomandat;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        setContentView(Constants.REGISTRATION_LAYOUT);

        username = findViewById(Constants.REGISTRATION_USERNAME);
        password = findViewById(Constants.REGISTRATION_PASSWORD);
        submit = findViewById(Constants.SUBMIT_BUTTON);
        cancel = findViewById(Constants.CANCEL_BUTTON);

        initializeFields();
        createSubmitListener();
        createCancelListener();
    }

    public void initializeFields(){
        username.setText(Constants.EMPTY_STRING);
        password.setText(Constants.EMPTY_STRING);
    }

    public void createSubmitListener(){
        submit.setOnClickListener(view -> {
            if(!username.getText().toString().equals(Constants.EMPTY_STRING) &&  !password.getText().toString().equals(Constants.EMPTY_STRING)){
                ClientModule client = new ClientModule(username.getText().toString(),  password.getText().toString());

                client.register(data -> {
                    if(data) finish();
                    else Toast.makeText(RegistrationActivity.this, Constants.ACCOUNT_CREATION_WARNING_MESSAGE, Toast.LENGTH_SHORT).show();
                });
            } else Toast.makeText(RegistrationActivity.this, Constants.EMPTY_FIELDS_WARNING_MESSAGE, Toast.LENGTH_SHORT).show();

        });
    }

    public void createCancelListener(){
        cancel.setOnClickListener(view -> {
            username.setText(Constants.EMPTY_STRING);
            password.setText(Constants.EMPTY_STRING);
            finish();
        });
    }

}
