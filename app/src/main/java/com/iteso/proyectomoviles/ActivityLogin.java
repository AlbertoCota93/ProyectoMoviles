package com.iteso.proyectomoviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class ActivityLogin extends AppCompatActivity {

    //private Button logIn;
    private CardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        card = findViewById(R.id.activity_login_logIn);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityLogin.this, ActivityMain.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
