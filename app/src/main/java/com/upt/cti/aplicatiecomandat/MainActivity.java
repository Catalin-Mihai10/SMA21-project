package com.upt.cti.aplicatiecomandat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Utilities.Category;
import com.upt.cti.aplicatiecomandat.Handlers.ProductDataHandler;
import com.upt.cti.aplicatiecomandat.Utilities.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button logOut;
    private Button cart;
    private TextView flours;
    private TextView lactate;
    private TextView fruits;
    private TextView vegetables;
    private TextView animals;
    private TextView oils;
    private ListView offers;
    private List<Item> items;
    private ProductDataHandler productDataHandler;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.MAIN_LAYOUT);

        logOut = findViewById(Constants.LOGOUT_BUTTON);
        cart = findViewById(Constants.CART_BUTTON);
        flours = findViewById(Constants.FLOURS_BUTTON);
        lactate = findViewById(Constants.LACTATE_BUTTON);
        fruits = findViewById(Constants.FRUITS_BUTTON);
        vegetables = findViewById(Constants.VEGETABLES_BUTTON);
        animals = findViewById(Constants.ANIMALS_BUTTON);
        oils = findViewById(Constants.OILS_BUTTON);
        offers = findViewById(Constants.OFFERS_VIEW);
        items = new ArrayList<>();

        productDataHandler = new ProductDataHandler();

        loadListOfOffers();

        createLogOutListener();
        createCartListener();
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

    public void createCartListener(){ cart.setOnClickListener(view ->  startActivity(new Intent(MainActivity.this, CartActivity.class)));}

    public void createFloursListener(){
        flours.setOnClickListener(view -> loadAdapter(Category.CEREALS));
    }

    private void loadAdapter(Category category) {
        items = productDataHandler.loadProductsFromDataBase(category, data -> {
            if(data){
                Log.d(Constants.MAIN_TAG, "cream un adapter nou");
                adapter = new ItemAdapter(MainActivity.this, Constants.ITEM_LAYOUT, items);
                offers.setAdapter(adapter);
            }
            else {
                Toast.makeText(MainActivity.this, "ERROR: Data could not be loaded!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void createLactateListener(){
        lactate.setOnClickListener(view -> loadAdapter(Category.LACTATE));
    }

    public void createFruitsListener(){
        fruits.setOnClickListener(view -> loadAdapter(Category.FRUITS));
    }

    public void createVegetablesListener(){
        vegetables.setOnClickListener(view -> loadAdapter(Category.VEGETABLES));
    }

    public void createAnimalsListener(){
        animals.setOnClickListener(view -> loadAdapter(Category.ANIMAL_PRODUCTS));
    }

    public void createOilsListener(){
        oils.setOnClickListener(view -> loadAdapter(Category.OILS));
    }

    public void loadListOfOffers(){
        loadAdapter(Category.OFFERS);
    }

}