package com.upt.cti.aplicatiecomandat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;
import com.upt.cti.aplicatiecomandat.Constants.Constants;

public class CardActivity extends AppCompatActivity {

    private CardForm cardForm;
    private Button buy;
    private AlertDialog.Builder alertBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(Constants.CARD_LAYOUT);

        cardForm = findViewById(Constants.CARD_FORM);
        buy = findViewById(Constants.BUY_BUTTON);

        setUpTheCardForm();
        createBuyButtonListener();
    }

    public void setUpTheCardForm(){
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS is required on this number")
                .setup(CardActivity.this);

        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    public void createBuyButtonListener(){
        buy.setOnClickListener(view -> {
            if(cardForm.isValid()){
                createAlertDialog();
            }
            else Toast.makeText(CardActivity.this, "You must complete all the fields!", Toast.LENGTH_LONG).show();
        });
    }

    public void createAlertDialog(){
        alertBuilder = new AlertDialog.Builder(CardActivity.this);
        alertBuilder.setTitle("Confirm before purchase");
        alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                                "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                                "Card CVV: " + cardForm.getCvv() + "\n" +
                                "Postal code: " + cardForm.getPostalCode() + "\n" +
                                "Phone number: " + cardForm.getMobileNumber());

        createPositiveButton();
        createNegativeButton();
    }

    public void createPositiveButton(){
        alertBuilder.setPositiveButton("Confirm", (dialogInterface, i) -> {
            dialogInterface.dismiss();
            Toast.makeText(CardActivity.this, "Thank you for purchase", Toast.LENGTH_LONG).show();
        });
    }

    public void createNegativeButton(){
        alertBuilder.setNegativeButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }
}
