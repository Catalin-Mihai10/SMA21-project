package com.upt.cti.aplicatiecomandat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_background);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }
}