package com.example.vaccinator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false))
        {
            finish();
        }

        button1 = (Button) findViewById(R.id.registerButton);
        button2 = (Button) findViewById(R.id.loginButton);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });

    }

    //the following functions open the respective pages
    public void openRegister() {

        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);

    }

    public void openLogin() {

        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);

    }

}