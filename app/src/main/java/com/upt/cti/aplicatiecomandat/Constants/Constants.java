package com.upt.cti.aplicatiecomandat.Constants;
import com.upt.cti.aplicatiecomandat.R;

public class Constants {

    //AuthenticationActivity Constants
    public static final String AUTHENTICATION_TAG = "AuthenticationActivity";
    public static final int USERNAME = R.id.usernameAuthentificationField;
    public static final int PASSWORD = R.id.passwordAuthentificationField;
    public static final int REGISTER_BUTTON = R.id.registerButton;
    public static final int LOGIN_BUTTON = R.id.loginButton;

    //RegistrationActivity Constants
    public static final String REGISTRATION_TAG = "RegistrationActivity";
    public static final int REGISTRATION_USERNAME = R.id.usernameRegistrationField;
    public static final int REGISTRATION_PASSWORD = R.id.passwordRegistrationField;
    public static final int SUBMIT_BUTTON = R.id.submitButton;
    public static final int CANCEL_BUTTON = R.id.cancelButton;

    //CommandHandler Constants
    public static final String COMMAND_HANDLER_TAG = "CommandHandler";

    //AuthenticationHandler Constants
    public static final String AUTHENTICATION_HANDLE_TAG = "AuthenticationHandler";
    public static final String DATABASE_URL = "https://proiect-sma-cf2fd-default-rtdb.europe-west1.firebasedatabase.app/";
    public static final String CHILD_USERS = "users";
    public static final String CHILD_USERNAME = "username";
    public static final String CHILD_PASSWORD = "password";

    //ProductDataHandler Constants
    public static final String PRODUCT_DATA_HANDLER_TAG = "ProductDataHandler";
    public static final String CHILD_PROVIDERS = "providers";

    //MainActivity Constants
    public static final String MAIN_TAG = "MainActivity";
    public static final int LOGOUT_BUTTON = R.id.logOutButton;
    public static final int FLOURS_BUTTON = R.id.tFainoase;
    public static final int LACTATE_BUTTON = R.id.tLactate;
    public static final int VEGETABLES_BUTTON = R.id.tFainoase;
    public static final int FRUITS_BUTTON = R.id.tLactate;
    public static final int ANIMALS_BUTTON = R.id.tFainoase;
    public static final int OILS_BUTTON = R.id.tLactate;
    public static final int OFFERS_VIEW = R.id.offersListView;
    public static final int CART_BUTTON = R.id.cartButton;

    //CartActivity Constants
    public static final String CART_TAG = "CartActivity";
    public static final int SUBMIT_COMMAND_BUTTON = R.id.submitCommandButton;
    public static final int CANCEL_COMMAND_BUTTON = R.id.cancelCommandButton;
    public static final int CART_LISTVIEW = R.id.cartListView;

    //ShipmentActivity Constants
    public static final String SHIPMENT_TAG = "ShipmentActivity";
    public static final int PHONE_FIELD = R.id.tPhone;
    public static final int ADDRESS_FIELD = R.id.tAdress;
    public static final int LOCAL_SPINNER = R.id.localitateSpinner;
    public static final int COUNTY_SPINNER = R.id.JudetSpinner;
    public static final int REPAYMENT_BUTTON = R.id.rambursButton;
    public static final int CARD_BUTTON = R.id.cardButton;
    public static final int BACK_BUTTON = R.id.backButton;

    //CardActivity Constants
    public static final String CARD_TAG = "CardActivity";

    //Universal Constants
    public static final String EMPTY_STRING = "";

    //Layouts
    public static final int AUTHENTICATION_LAYOUT = R.layout.authentification;
    public static final int REGISTRATION_LAYOUT = R.layout.registration;
    public static final int MAIN_LAYOUT = R.layout.activity_main;
    public static final int ITEM_LAYOUT = R.layout.item;
    public static final int CART_LAYOUT = R.layout.cart_activity;
    public static final int CART_ITEM_LAYOUT = R.layout.cart_item;
    public static final int SHIPMENT_LAYOUT = R.layout.shipment_information_activity;
    public static final int CARD_LAYOUT = R.layout.card_activity;

    //ItemAdapter Constants
    public static final int ITEM_NAME_FIELD = R.id.tName;
    public static final int ITEM_COST_FIELD = R.id.tCost;
    public static final int ITEM_PROVIDER_FIELD = R.id.tProvider;
    public static final int ITEM_CATEGORY_FIELD = R.id.tCategory;
    public static final int ADD_ITEM_BUTTON = R.id.addButtton;

    //CartItemAdapter Constants
    public static final int CART_ITEM_NAME_FIELD = R.id.cartTName;
    public static final int CART_ITEM_COST_FIELD = R.id.cartTCost;
    public static final int CART_ITEM_QUANTITY_FIELD = R.id.tCantitate;
    public static final int REMOVE_ITEM_FROM_CART_BUTTON = R.id.removeButton;
}
