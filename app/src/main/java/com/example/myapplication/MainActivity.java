package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText textInputEditText_email, TextInputEditText_password;
    LinearLayout linearLayout_login;
    String emailOK = "123@gmail.com", passwordOK = "1234";
    String inputEmail = "", inputPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditText_email = findViewById(R.id.TextInputEditText_email);
        TextInputEditText_password = findViewById(R.id.TextInputEditText_password);
        linearLayout_login = findViewById(R.id.LinearLayout_login);

        textInputEditText_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null) {
                    inputEmail = s.toString();
                    linearLayout_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        TextInputEditText_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null) {
                    inputPassword = s.toString();
                    linearLayout_login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        linearLayout_login.setClickable(false);
        linearLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = textInputEditText_email.getText().toString();
                String password = TextInputEditText_password.getText().toString();

                Intent intent = new Intent(getApplicationContext(), LoginResultActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);

            }
        });

    }

    public boolean validation() {
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}