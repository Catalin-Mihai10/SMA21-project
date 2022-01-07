package com.upt.cti.aplicatiecomandat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.installations.Utils;
import com.google.gson.Gson;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.PurchaseInformation;
import com.upt.cti.aplicatiecomandat.DataTypes.State;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.Handlers.DataHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ShipmentActivity extends AppCompatActivity {

    private EditText tPhone;
    private EditText tAddress;
    private Spinner localSpinner;
    private Spinner stateSpinner;
    private Button repayment, card, back;
    private ArrayList<State> states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.SHIPMENT_LAYOUT);

        tPhone = findViewById(Constants.PHONE_FIELD);
        tAddress = findViewById(Constants.ADDRESS_FIELD);
        localSpinner = findViewById(Constants.LOCAL_SPINNER);
        stateSpinner = findViewById(Constants.COUNTY_SPINNER);
        repayment = findViewById(Constants.REPAYMENT_BUTTON);
        card = findViewById(Constants.CARD_BUTTON);
        back = findViewById(Constants.BACK_BUTTON);

        try {
            loadDataFromJson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        populateCountySpinner(states);

        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedState  = stateSpinner.getSelectedItem().toString();
                populateLocalSpinner(states, selectedState);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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
            stateSpinner.clearFocus();
            finish();
        });
    }

    //TODO: populate spinners
    public void populateLocalSpinner(ArrayList<State> states, String selectedState){
        ArrayList<String> cityNames = new ArrayList<>();
        for(State state : states)
            if(state.getStateName().equals(selectedState))
                cityNames.add(state.getCity());

        ArrayAdapter<String> localeArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, cityNames);
        localeArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localSpinner.setAdapter(localeArrayAdapter);
    }

    public void populateCountySpinner(ArrayList<State> states){
        ArrayList<String> statesNames = new ArrayList<>();
        for(State state : states)
            statesNames.add(state.getStateName());

        ArrayAdapter<String> countriesArrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                        android.R.layout.simple_spinner_dropdown_item, statesNames);
        countriesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stateSpinner.setAdapter(countriesArrayAdapter);

    }


    public void loadDataFromJson() throws FileNotFoundException {
        String PATH = getJsonFromAssets(getApplicationContext(), "localitati.json");
        Log.d(Constants.SHIPMENT_TAG, PATH);

        //BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\Proiect-SMA\\app\\src\\main\\assets\\localitati.json"));
        State[] jsonStates = new Gson().fromJson(PATH, State[].class);
        states = new ArrayList<>(Arrays.asList(jsonStates));
    }

    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
}
