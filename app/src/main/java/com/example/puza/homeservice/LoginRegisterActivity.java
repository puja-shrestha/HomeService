package com.example.puza.homeservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);

        Button loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(LoginRegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Button btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(LoginRegisterActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
