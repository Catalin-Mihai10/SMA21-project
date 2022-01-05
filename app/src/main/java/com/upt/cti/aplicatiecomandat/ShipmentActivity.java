package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;

import java.util.ArrayList;

public class ShipmentActivity extends AppCompatActivity {

    private EditText tPhone;
    private EditText tAddress;
    private Spinner localSpinner;
    private Spinner countySpinner;
    private Button repayment, card, back;

    //TODO: populate arrayLists with names
    ArrayList<String> localNames = new ArrayList<String>(){{
        add("");
    }};
    ArrayList<String> countyNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.SHIPMENT_LAYOUT);

        tPhone = findViewById(Constants.PHONE_FIELD);
        tAddress = findViewById(Constants.ADDRESS_FIELD);
        localSpinner = findViewById(Constants.LOCAL_SPINNER);
        countySpinner = findViewById(Constants.COUNTY_SPINNER);
        repayment = findViewById(Constants.REPAYMENT_BUTTON);
        card = findViewById(Constants.CARD_BUTTON);
        back = findViewById(Constants.BACK_BUTTON);

        populateLocalSpinner();
        populateCountySpinner();

        createRepaymentListener();
        createCardListener();
        createBackListener();
    }

    public void createRepaymentListener(){
        repayment.setOnClickListener(view -> {
            //TODO: goes back to MainActivity
            finish();
        });
    }

    public void createCardListener(){
        card.setOnClickListener(view -> {
            //TODO: Opens a new activity
            startActivity(new Intent(ShipmentActivity.this, CardActivity.class));
        });
    }

    public void createBackListener(){
        back.setOnClickListener(view -> {
            tPhone.setText(Constants.EMPTY_STRING);
            tAddress.setText(Constants.EMPTY_STRING);
            localSpinner.clearFocus();
            countySpinner.clearFocus();
            finish();
        });
    }

    //TODO: populate spinners
    public void populateLocalSpinner(){

    }

    public void populateCountySpinner(){

    }
}
