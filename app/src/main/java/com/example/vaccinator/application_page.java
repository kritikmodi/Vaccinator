package com.example.vaccinator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class application_page extends AppCompatActivity {

    TextView e1, e2, e3, e4, e5, e6;
    Button exitbutton;

    DBHelper usersDB;
    Boolean insertResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);

        e1 = (TextView)findViewById(R.id.textView23);
        e2 = (TextView)findViewById(R.id.textView28);
        e3 = (TextView)findViewById(R.id.textView25);
        e4 = (TextView)findViewById(R.id.textView26);
        e5 = (TextView)findViewById(R.id.textView27);
        e6 = (TextView)findViewById(R.id.textView29);

        e1.setText("24411234");
        e2.setText("12345");
        e3.setText("001");
        e4.setText("Covishield");
        e5.setText("KSLayout");
        e6.setText("1");

        exitbutton = (Button) findViewById(R.id.exitbutton);

        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });

    }
}