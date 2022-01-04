package com.upt.cti.aplicatiecomandat;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.upt.cti.aplicatiecomandat.Constants.Constants;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.CARD_LAYOUT);
    }
}
