package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.PurchaseInformation;
import com.upt.cti.aplicatiecomandat.DataTypes.StatesAndCities;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.Handlers.DataHandler;

import java.util.ArrayList;

public class ShipmentActivity extends AppCompatActivity {

    private EditText tPhone;
    private EditText tAddress;
    private Spinner citySpinner;
    private Spinner stateSpinner;
    private Button repayment, card, back;
    private StatesAndCities statesAndCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.SHIPMENT_LAYOUT);

        tPhone = findViewById(Constants.PHONE_FIELD);
        tAddress = findViewById(Constants.ADDRESS_FIELD);
        citySpinner = findViewById(Constants.LOCAL_SPINNER);
        stateSpinner = findViewById(Constants.COUNTY_SPINNER);
        repayment = findViewById(Constants.REPAYMENT_BUTTON);
        card = findViewById(Constants.CARD_BUTTON);
        back = findViewById(Constants.BACK_BUTTON);
        statesAndCities = new StatesAndCities();

        populateCountySpinner();
        createStateSpinnerListener();
        createCitySpinnerListener();
        createRepaymentListener();
        createCardListener();
        createBackListener();
    }


    public void createRepaymentListener(){
        repayment.setOnClickListener(view -> {
            if(!tPhone.getText().toString().equals(Constants.EMPTY_STRING) &&  !tAddress.getText().toString().equals(Constants.EMPTY_STRING)){
                CommandHandler.setPurchaseInformation(new PurchaseInformation(CommandHandler.getApplicationUser().getUserID(),
                        tPhone.getText().toString(), tAddress.getText().toString(), stateSpinner.getSelectedItem().toString(), citySpinner.getSelectedItem().toString()));
                DataHandler dataHandler = new DataHandler();
                dataHandler.processItemData(CommandHandler.getFinalCommand(), CommandHandler.getPurchaseInformation());
                finish();
            } else Toast.makeText(ShipmentActivity.this, Constants.EMPTY_FIELDS_WARNING_MESSAGE, Toast.LENGTH_SHORT).show();
        });
    }

    public void createCardListener(){
        card.setOnClickListener(view -> {

            if(!tPhone.getText().toString().equals(Constants.EMPTY_STRING) &&  !tAddress.getText().toString().equals(Constants.EMPTY_STRING)){
                CommandHandler.setPurchaseInformation(new PurchaseInformation(CommandHandler.getApplicationUser().getUserID(),
                        tPhone.getText().toString(), tAddress.getText().toString(), stateSpinner.getSelectedItem().toString(), citySpinner.getSelectedItem().toString()));
                startActivity(new Intent(ShipmentActivity.this, CardActivity.class));
                finish();
            } else Toast.makeText(ShipmentActivity.this, Constants.EMPTY_FIELDS_WARNING_MESSAGE, Toast.LENGTH_SHORT).show();
        });
    }

    public void createBackListener(){
        back.setOnClickListener(view -> {
            tPhone.setText(Constants.EMPTY_STRING);
            tAddress.setText(Constants.EMPTY_STRING);
            citySpinner.clearFocus();
            stateSpinner.clearFocus();
            finish();
        });
    }

    public void populateLocalSpinner(String selectedState){
        ArrayList<String> cityNames = new ArrayList<>();
        statesAndCities.getCities().forEach((state, city) -> {
            if(state.equals(selectedState)) cityNames.add(city);
        });

        ArrayAdapter<String> localeArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, cityNames);
        localeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(localeArrayAdapter);
    }

    public void populateCountySpinner(){
        ArrayAdapter<String> countriesArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, statesAndCities.getStates());
        countriesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(countriesArrayAdapter);

    }

    public void createStateSpinnerListener(){
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(stateSpinner.getSelectedItem() != null){
                    String selectedState  = stateSpinner.getSelectedItem().toString();
                    populateLocalSpinner(selectedState);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void createCitySpinnerListener(){
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(citySpinner.getSelectedItem() != null){
                    String selectedState  = citySpinner.getSelectedItem().toString();
                    populateLocalSpinner(selectedState);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
