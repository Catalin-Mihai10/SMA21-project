package com.upt.cti.aplicatiecomandat;

import android.os.Bundle;
import android.text.InputType;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;
import com.upt.cti.aplicatiecomandat.Constants.Constants;
import com.upt.cti.aplicatiecomandat.Handlers.CommandHandler;
import com.upt.cti.aplicatiecomandat.Handlers.DataHandler;

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
                .mobileNumberExplanation(Constants.MOBILE_NUMBER_EXPLANATION)
                .setup(CardActivity.this);

        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
    }

    public void createBuyButtonListener(){
        buy.setOnClickListener(view -> {
            if(cardForm.isValid()){
                createAlertDialog();
            }
            else Toast.makeText(CardActivity.this, Constants.EMPTY_FIELDS_WARNING_MESSAGE, Toast.LENGTH_LONG).show();
        });
    }

    public void createAlertDialog(){
        alertBuilder = new AlertDialog.Builder(CardActivity.this);
        alertBuilder.setTitle(Constants.ALERT_DIALOG_TITLE);

        String cardExpirationDate = Constants.EMPTY_STRING;
        if(cardForm.getExpirationDateEditText().getText() != null) cardExpirationDate = cardForm.getExpirationDateEditText().getText().toString();

        alertBuilder.setMessage(Constants.NUMBER_FIELD + cardForm.getCardNumber() + Constants.NEW_LINE +
                                Constants.CARD_EXPIRATION_DATE + cardExpirationDate + Constants.NEW_LINE +
                                Constants.CARD_CVV + cardForm.getCvv() + Constants.NEW_LINE +
                                Constants.POST_CODE + cardForm.getPostalCode() + Constants.NEW_LINE +
                                Constants.PHONE_NUMBER + cardForm.getMobileNumber());

        createPositiveButton();
        createNegativeButton();
    }

    public void createPositiveButton(){
        alertBuilder.setPositiveButton(Constants.CONFIRMATION, (dialogInterface, i) -> {
            dialogInterface.dismiss();
            DataHandler dataHandler = new DataHandler();
            CommandHandler.setPhone(cardForm.getMobileNumber());

            if(dataHandler.processItemData(CommandHandler.getFinalCommand(), CommandHandler.getPurchaseInformation())){
                Toast.makeText(CardActivity.this, Constants.PURCHASE_SUCCESS_MESSAGE, Toast.LENGTH_LONG).show();
                finish();
            }
            else Toast.makeText(CardActivity.this, Constants.PURCHASE_WARNING_MESSAGE, Toast.LENGTH_LONG).show();

        });
    }

    public void createNegativeButton(){
        alertBuilder.setNegativeButton(Constants.CANCEL, (dialogInterface, i) -> dialogInterface.dismiss());
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }
}
