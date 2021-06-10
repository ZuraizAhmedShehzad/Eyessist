package com.fyp.fypui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mainmenu extends AppCompatActivity {

    Button btn_appliance;
    DatabaseReference reference;
    DatabaseError databaseError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        LinearLayout fanmenu = (LinearLayout)findViewById(R.id.fanmenu);
        ImageView image = (ImageView)findViewById(R.id.fanimage);
        TextView l = findViewById(R.id.Label);
//        GetData(l);

        fanmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.down);

            }
        });

    }

//    public void GetData(TextView l){
//        reference = FirebaseDatabase.getInstance().getReference().child("User").child("User2");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String user = snapshot.child("id").getValue().toString();
//                String pass = snapshot.child("pass").getValue().toString();
//                l.setText(user);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });}

}