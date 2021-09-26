package com.example.vaccinator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {

    //the following lines declare the EditText variables and the Register Button variable
    EditText name, dob, aadhaar_number, city, state, pincode, phone_number;
    Button register;
    DBHelper usersDB;
    Boolean insertResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        //the following lines store values into the declared variables according to their respective ids
        name = (EditText) findViewById(R.id.editTextTextPersonName);
        dob = (EditText) findViewById(R.id.editTextTextPersonDob);
        aadhaar_number = (EditText) findViewById(R.id.editTextTextPersonAadhaar);
        city = (EditText) findViewById(R.id.editTextTextPersonCity);
        state = (EditText) findViewById(R.id.editTextTextPersonState);
        pincode = (EditText) findViewById(R.id.editTextTextPersonPincode);
        phone_number = (EditText) findViewById(R.id.editTextTextPersonPhone);

        register = (Button) findViewById(R.id.registerButton2);

        usersDB = new DBHelper(this);

        //the following function contains the code which will be executed when the Register button is clicked
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = name.getText().toString();
                String userdob = dob.getText().toString();
                String useraadhaar = aadhaar_number.getText().toString();
                String usercity = city.getText().toString();
                String userstate = state.getText().toString();
                String userpincode = pincode.getText().toString();
                String userphone = phone_number.getText().toString();
                if(username.equals("")||userdob.equals("")||useraadhaar.equals("")||usercity.equals("")||userstate.equals("")||userpincode.equals("")||userphone.equals(""))
                    Toast.makeText(RegisterPage.this, "Please fill all the fields!", Toast.LENGTH_SHORT).show();
                    //the above line is used to display a message on the screen
                else{
                     Boolean checkResult = usersDB.checkUserExists(useraadhaar);
                     if(checkResult==false) {
                         insertResult = usersDB.insertData(username, userdob, useraadhaar, usercity, userstate, userpincode, userphone);
                         if (insertResult==true) {
                             Toast.makeText(RegisterPage.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                             openHomePage();
                         }
                         else
                             Toast.makeText(RegisterPage.this, "Registration Failed!", Toast.LENGTH_LONG).show();
                     }
                     else {
                         Toast.makeText(RegisterPage.this, "User already exists!\nPlease try to Login!", Toast.LENGTH_LONG).show();
                         openLogin();
                     }
                }
            }
        });

    }

    public void openLogin(){

        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);

    }

    public void openHomePage(){

        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);

    }

}