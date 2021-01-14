package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class LoginResultActivity extends AppCompatActivity {

    TextView textView_email, textView_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_email = findViewById(R.id.TextView_email);
        textView_password = findViewById(R.id.TextView_password);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        textView_email.setText(bundle.getString("email"));
        textView_password.setText(bundle.getString("password"));
    }
}