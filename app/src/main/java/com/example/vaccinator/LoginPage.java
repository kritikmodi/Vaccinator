package com.example.vaccinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText aadhaar;
    Button login;
    DBHelper usersDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        aadhaar = (EditText)findViewById(R.id.aadhaarLogin);
        login = (Button)findViewById(R.id.loginButton2);

        usersDB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String useraadhaar = aadhaar.getText().toString();
                Boolean checkResult = usersDB.checkUserExists(useraadhaar);
                if(checkResult==true){
                    Toast.makeText(LoginPage.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    openHomePage();
                }
                else{
                    Toast.makeText(LoginPage.this, "User not registered!\nPlease try to Register!", Toast.LENGTH_LONG).show();
                    openRegister();
                }

            }
        });
    }

    public void openRegister(){

        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);

    }

    public void openHomePage(){

        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

    }
}