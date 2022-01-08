package com.upt.cti.aplicatiecomandat.Constants;
import com.upt.cti.aplicatiecomandat.R;

public class Constants {

    //AuthenticationActivity Constants
    public static final int USERNAME = R.id.usernameAuthentificationField;
    public static final int PASSWORD = R.id.passwordAuthentificationField;
    public static final int REGISTER_BUTTON = R.id.registerButton;
    public static final int LOGIN_BUTTON = R.id.loginButton;
    public static final String USER_WARNING_MESSAGE = "Username or password wrong!";
    public static final String EMPTY_FIELDS_WARNING_MESSAGE = "Please complete both fields!";

    //RegistrationActivity Constants
    public static final int REGISTRATION_USERNAME = R.id.usernameRegistrationField;
    public static final int REGISTRATION_PASSWORD = R.id.passwordRegistrationField;
    public static final int SUBMIT_BUTTON = R.id.submitButton;
    public static final int CANCEL_BUTTON = R.id.cancelButton;
    public static final String ACCOUNT_CREATION_WARNING_MESSAGE = "An account with this name already exist!";

    //AuthenticationHandler Constants
    public static final String DATABASE_URL = "https://proiect-sma-cf2fd-default-rtdb.europe-west1.firebasedatabase.app/";
    public static final String CHILD_USERS = "users";
    public static final String CHILD_USERNAME = "username";
    public static final String CHILD_PASSWORD = "password";

    //ProductDataHandler Constants
    public static final String CHILD_PROVIDERS = "providers";

    //MainActivity Constants
    public static final int LOGOUT_BUTTON = R.id.logOutButton;
    public static final int FLOURS_BUTTON = R.id.floursButton;
    public static final int LACTATE_BUTTON = R.id.lactateButton;
    public static final int VEGETABLES_BUTTON = R.id.vegetablesButton;
    public static final int FRUITS_BUTTON = R.id.fruitsButton;
    public static final int ANIMALS_BUTTON = R.id.meatsButton;
    public static final int OILS_BUTTON = R.id.oilsButton;
    public static final int OFFERS_BUTTON = R.id.offersButton;
    public static final int OFFERS_VIEW = R.id.offersListView;
    public static final int CART_BUTTON = R.id.cartButton;
    public static final String DATA_LOADING_WARNING_MESSAGE = "ERROR: Data could not be loaded!";

    //CartActivity Constants
    public static final int SUBMIT_COMMAND_BUTTON = R.id.submitCommandButton;
    public static final int CANCEL_COMMAND_BUTTON = R.id.cancelCommandButton;
    public static final int CART_LISTVIEW = R.id.cartListView;
    public static final String CONFIRM_COMMAND_WARNING_MESSAGE = "You don't have items to purchase";

    //ShipmentActivity Constants
    public static final int PHONE_FIELD = R.id.tPhone;
    public static final int ADDRESS_FIELD = R.id.tAdress;
    public static final int LOCAL_SPINNER = R.id.localitateSpinner;
    public static final int COUNTY_SPINNER = R.id.JudetSpinner;
    public static final int REPAYMENT_BUTTON = R.id.rambursButton;
    public static final int CARD_BUTTON = R.id.cardButton;
    public static final int BACK_BUTTON = R.id.backButton;

    //CardActivity Constants
    public static final int CARD_FORM = R.id.cardForm;
    public static final int BUY_BUTTON = R.id.buyButton;
    public static final String ALERT_DIALOG_TITLE = "Confirm before purchase";
    public static final String MOBILE_NUMBER_EXPLANATION = "SMS is required on this number";
    public static final String PURCHASE_WARNING_MESSAGE = "Purchase failed";
    public static final String PURCHASE_SUCCESS_MESSAGE = "Thank you for purchase";
    public static final String NUMBER_FIELD = "Card number: ";
    public static final String CARD_EXPIRATION_DATE =  "Card expiry date: ";
    public static final String CARD_CVV = "Card CVV: ";
    public static final String POST_CODE = "Postal code: ";
    public static final String PHONE_NUMBER = "Phone number: ";
    public static final String CONFIRMATION = "Confirm";
    public static final String CANCEL = "Cancel";

    //Universal Constants
    public static final String EMPTY_STRING = "";
    public static final String NEW_LINE = "\n";

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
    public static String DEFAULT_QUANTITY = "1";
    public static final int ITEM_NAME_FIELD = R.id.tName;
    public static final int ITEM_COST_FIELD = R.id.tCost;
    public static final int ITEM_PROVIDER_FIELD = R.id.tProvider;
    public static final int ITEM_CATEGORY_FIELD = R.id.tCategory;
    public static final int ADD_ITEM_BUTTON = R.id.addButtton;
    public static final int ADD_QUANTITY = R.id.addQuantityButton;
    public static final int SUBTRACT_QUANTITY = R.id.substractQuantityButton;
    public static final int ITEM_QUANTITY_FIELD = R.id.tQuantity;

    //CartItemAdapter Constants
    public static final int CART_ITEM_NAME_FIELD = R.id.cartTName;
    public static final int CART_ITEM_COST_FIELD = R.id.cartTCost;
    public static final int CART_ITEM_QUANTITY_FIELD = R.id.tCantitate;
    public static final int REMOVE_ITEM_FROM_CART_BUTTON = R.id.removeButton;

    //DataHandler Constants
    public static final String CHILD_COMMAND = "commands";
    public static final String CHILD_ITEMS = "items";
}
