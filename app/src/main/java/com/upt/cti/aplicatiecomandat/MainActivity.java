package com.upt.cti.aplicatiecomandat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.upt.cti.aplicatiecomandat.Constants.Constants;

public class MainActivity extends AppCompatActivity {
    private Button logOut;
    private TextView flours;
    private TextView lactate;
    private TextView fruits;
    private TextView vegetables;
    private TextView animals;
    private TextView oils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logOut = findViewById(Constants.LOGOUT_BUTTON);
        flours = findViewById(Constants.FLOURS_BUTTON);
        lactate = findViewById(Constants.LACTATE_BUTTON);
        fruits = findViewById(Constants.FRUITS_BUTTON);
        vegetables = findViewById(Constants.VEGETABLES_BUTTON);
        animals = findViewById(Constants.ANIMALS_BUTTON);
        oils = findViewById(Constants.OILS_BUTTON);

        createLogOutListener();
        createFloursListener();
        createLactateListener();
        createFruitsListener();
        createVegetablesListener();
        createAnimalsListener();
        createOilsListener();
    }

    public void createLogOutListener(){
        logOut.setOnClickListener(view -> finish());
    }

    //TODO: cand apasam butoanele sa incarcam produsele respective pentru fiecare categorie
    public void createFloursListener(){
    }

    public void createLactateListener(){}

    public void createFruitsListener(){}

    public void createVegetablesListener(){}

    public void createAnimalsListener(){}

    public void createOilsListener(){}

}