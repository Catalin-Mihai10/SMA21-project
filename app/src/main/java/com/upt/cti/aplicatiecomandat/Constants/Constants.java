package com.upt.cti.aplicatiecomandat.Constants;
import com.upt.cti.aplicatiecomandat.R;

public class Constants {

    //MainActivity Constants
    public static final String AUTHENTIFICATION_TAG = "AuthentificationActivity";
    public static final int USERNAME = R.id.usernameAuthentificationField;
    public static final int PASSWORD = R.id.passwordAuthentificationField;
    public static final int REGISTER_BUTTON = R.id.registerButton;
    public static final int LOGIN_BUTTON = R.id.loginButton;

    //RegitstrationActivity Constants
    public static final String REGISTRATION_TAG = "RegistrationActivity";
    public static final int REGISTRATION_USERNAME = R.id.usernameRegistrationField;
    public static final int REGISTRATION_PASSWORD = R.id.passwordRegistrationField;
    public static final int SUBMIT_BUTTON = R.id.submitButton;
    public static final int CANCEL_BUTTON = R.id.cancelButton;

    //CommandHandler Constants
    public static final String COMMANDHANDLER_TAG = "CommandHandler";

    //AuthentificationHandler Constants
    public static final String AUTHENTIFICATION_HANDLE_TAG = "AuthentificationHandler";
    public static final String DATABASE_URL = "https://proiect-sma-cf2fd-default-rtdb.europe-west1.firebasedatabase.app/";
    public static final String CHILD_USERS = "users";
    public static final String CHILD_USERNAME = "username";
    public static final String CHILD_PASSWORD = "password";

    //Universal Constants
    public static final String EMPTY_STRING = "";
}
