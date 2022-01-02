package com.upt.cti.aplicatiecomandat.Constants;
import com.upt.cti.aplicatiecomandat.R;

public class Constants {

    //MainActivity Constants
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
    public static final int LOGOUT_BUTTON = R.id.logOutButton;
    public static final int FLOURS_BUTTON = R.id.tFainoase;
    public static final int LACTATE_BUTTON = R.id.tLactate;
    public static final int VEGETABLES_BUTTON = R.id.tFainoase;
    public static final int FRUITS_BUTTON = R.id.tLactate;
    public static final int ANIMALS_BUTTON = R.id.tFainoase;
    public static final int OILS_BUTTON = R.id.tLactate;
    public static final int OFFERS_VIEW = R.id.offersListView;

    //Universal Constants
    public static final String EMPTY_STRING = "";
}
