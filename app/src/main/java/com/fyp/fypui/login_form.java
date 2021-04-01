package com.fyp.fypui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
    }

    public void btn_signupform(View view) {
        startActivity(new Intent(getApplicationContext(),signup_form.class));
    }
    public void btn_dashboard(View view){
        startActivity(new Intent(getApplicationContext(),appliance.class));
    }
}

