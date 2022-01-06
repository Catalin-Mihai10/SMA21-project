package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.CountriesAndLocales;
import com.upt.cti.aplicatiecomandat.DataTypes.PurchaseInformation;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.Handlers.DataHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ShipmentActivity extends AppCompatActivity {

    private EditText tPhone;
    private EditText tAddress;
    private Spinner localSpinner;
    private Spinner countySpinner;
    private Button repayment, card, back;

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

        CountriesAndLocales countriesAndLocales = new CountriesAndLocales();
        populateLocalSpinner(countriesAndLocales.getLocales());
        populateCountySpinner(countriesAndLocales.getCountries());

        createRepaymentListener();
        createCardListener();
        createBackListener();
    }

    public void createRepaymentListener(){
        repayment.setOnClickListener(view -> {
            CommandHandler.setPurchaseInformation(new PurchaseInformation(CommandHandler.getApplicationUser().getUserID(),
                    tPhone.getText().toString(), tAddress.getText().toString(), "", ""));
            DataHandler dataHandler = new DataHandler();
            dataHandler.processItemData(CommandHandler.getFinalCommand(), CommandHandler.getPurchaseInformation());
            finish();
        });
    }

    public void createCardListener(){
        card.setOnClickListener(view -> {
            CommandHandler.setPurchaseInformation(new PurchaseInformation(CommandHandler.getApplicationUser().getUserID(),
                    "", tAddress.getText().toString(), "", ""));
            startActivity(new Intent(ShipmentActivity.this, CardActivity.class));
            finish();
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
    public void populateLocalSpinner(Locale[] locales){
        ArrayAdapter<Locale[]> localeArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, Collections.singletonList(locales));
        localeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localeArrayAdapter);
    }

    public void populateCountySpinner(ArrayList<String> countries){
        ArrayAdapter<String> countriesArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, countries);
        countriesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countySpinner.setAdapter(countriesArrayAdapter);

    }
}
