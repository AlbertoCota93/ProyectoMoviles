package com.iteso.proyectomoviles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class ActivityLogin extends AppCompatActivity {

    //private Button logIn;
    private CardView card;
    CallbackManager callbackManager;
    private EditText email;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);

       // logIn = findViewById(R.id.activity_log_in_logIn);

        /*logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });*/
        email = findViewById(R.id.activity_log_in_email);
        pwd = findViewById(R.id.activity_log_in_pass);
        card = findViewById(R.id.activity_login_logIn);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("") || pwd.getText().toString().equals("") ) {
                    Toast warning = Toast.makeText(ActivityLogin.this, "Ni email ni Password pueden ser vacíos!",
                            Toast.LENGTH_SHORT);
                    warning.show();
                } else {
                    saveSharedPreferences();
                    Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        LoginButton loginButton = findViewById(R.id.activity_login_face_login);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "user_friends", "email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchUserInfor();
    }

    private void fetchUserInfor() {

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        if(accessToken != null) {
            Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
            startActivity(intent);
            finish();
        }
    }

    private void saveSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                ActivitySplashScreen.MYPREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("EMAIL", email.getText().toString());
        editor.putString("FWD", pwd.getText().toString());
        editor.putBoolean("LOGGER", true);
        editor.apply();
    }
}
