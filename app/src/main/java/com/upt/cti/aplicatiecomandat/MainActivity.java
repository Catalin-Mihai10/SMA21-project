package com.upt.cti.aplicatiecomandat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.DataTypes.Item;
import com.upt.cti.aplicatiecomandat.Utilities.Category;
import com.upt.cti.aplicatiecomandat.Handlers.ProductDataHandler;
import com.upt.cti.aplicatiecomandat.Utilities.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button logOut;
    private TextView flours;
    private TextView lactate;
    private TextView fruits;
    private TextView vegetables;
    private TextView animals;
    private TextView oils;
    private List<Item> items;
    private ProductDataHandler productDataHandler;

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
        ListView offers = findViewById(Constants.OFFERS_VIEW);
        items = new ArrayList<>();

        productDataHandler = new ProductDataHandler();

        loadListOfOffers();

        final ItemAdapter adapter = new ItemAdapter(this, R.layout.item, items);
        offers.setAdapter(adapter);

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

    public void createFloursListener(){
        flours.setOnClickListener(view -> items = productDataHandler.loadProductsFromDataBase(Category.CEREALS));
    }

    public void createLactateListener(){
        lactate.setOnClickListener(view -> items = productDataHandler.loadProductsFromDataBase(Category.LACTATE));
    }

    public void createFruitsListener(){
        fruits.setOnClickListener(view -> items = productDataHandler.loadProductsFromDataBase(Category.FRUITS));
    }

    public void createVegetablesListener(){
        vegetables.setOnClickListener(view -> items = productDataHandler.loadProductsFromDataBase(Category.VEGETABLES));
    }

    public void createAnimalsListener(){
        animals.setOnClickListener(view -> items = productDataHandler.loadProductsFromDataBase(Category.ANIMAL_PRODUCTS));
    }

    public void createOilsListener(){
        oils.setOnClickListener(view -> items = productDataHandler.loadProductsFromDataBase(Category.OILS));
    }

    public void loadListOfOffers(){
        items = productDataHandler.loadProductsFromDataBase(Category.OFFERS);
    }

}