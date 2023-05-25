package com.pontic_studio.myproperty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public Button logInButton;
    public EditText usernameText;
    public EditText passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        logInButton=findViewById(R.id.logInButtonChangeView);

        usernameText=findViewById(R.id.logInTextUsername);
        passwordText=findViewById(R.id.logInTextPassword);
    }
}