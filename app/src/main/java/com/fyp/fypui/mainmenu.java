package com.fyp.fypui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class mainmenu extends AppCompatActivity {

    Button btn_appliance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        LinearLayout fanmenu = (LinearLayout)findViewById(R.id.fanmenu);
        ImageView image = (ImageView)findViewById(R.id.fanimage);

        fanmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.down);

            }
        });

    }

}