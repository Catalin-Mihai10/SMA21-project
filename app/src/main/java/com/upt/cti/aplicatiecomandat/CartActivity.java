package com.upt.cti.aplicatiecomandat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.Utilities.CartItemAdapter;

public class CartActivity extends AppCompatActivity {

    private ListView cartListView;
    private Button submitCommand;
    private Button cancelCommand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.CART_LAYOUT);

        cartListView = findViewById(Constants.CART_LISTVIEW);
        submitCommand = findViewById(Constants.SUBMIT_COMMAND_BUTTON);
        cancelCommand = findViewById(Constants.CANCEL_COMMAND_BUTTON);

        loadCartData();
        createSubmitCommandListener();
        createCancelCommandListener();
    }

    public void loadCartData(){
        CartItemAdapter adapter = new CartItemAdapter(CartActivity.this, Constants.CART_ITEM_LAYOUT, CommandHandler.getCart());
        cartListView.setAdapter(adapter);
    }

    public void createSubmitCommandListener(){
        submitCommand.setOnClickListener(view -> {
            startActivity(new Intent(CartActivity.this, ShipmentActivity.class));
            finish();
        });
    }

    public void createCancelCommandListener(){
        cancelCommand.setOnClickListener(view -> finish());
    }
}
