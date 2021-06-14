package com.fyp.fypui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class mainmenu extends AppCompatActivity {

    Button btn_appliance;
    DatabaseReference reference;
    DatabaseError databaseError;
    String bulb,fan,lock;
    private DatabaseReference mDatabase;
    FirebaseAuth fAuth;
    private String acpin;
    boolean acpincheck=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        TextView wlcm = (TextView)findViewById(R.id.wlcmtxt);
        SwitchMaterial fswitch = (SwitchMaterial) findViewById(R.id.fanswitch);
        SwitchMaterial bswitch = (SwitchMaterial) findViewById(R.id.bswitch);
        SwitchMaterial lswitch = (SwitchMaterial) findViewById(R.id.lswitch);
        LinearLayout flin = (LinearLayout) findViewById(R.id.fanmenu);
        LinearLayout blin = (LinearLayout) findViewById(R.id.bulbmenu);
        LinearLayout llin = (LinearLayout) findViewById(R.id.lockmenu);
        ImageView fanimg = (ImageView) findViewById(R.id.fanimage);
        ImageView bulbimg = (ImageView) findViewById(R.id.bulbimage);
        ImageView lockimg = (ImageView) findViewById(R.id.lockimage);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();


        mDatabase.child(fAuth.getCurrentUser().getUid().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                } else {
                    acpin = String.valueOf(task.getResult().getValue());



                    reference = FirebaseDatabase.getInstance().getReference().child(acpin);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            fan = snapshot.child("FAN").child("STATE").getValue().toString();
                            bulb = snapshot.child("BULB").child("STATE").getValue().toString();
                            lock = snapshot.child("LOCK").child("STATE").getValue().toString();
                            setSwitch(fan,fswitch,flin,fanimg,R.drawable.fan,R.drawable.fanwhite);
                            setSwitch(bulb,bswitch,blin,bulbimg,R.drawable.bulb,R.drawable.bulbwhite);
                            setSwitch(lock,lswitch,llin,lockimg,R.drawable.lock,R.drawable.lockwhite);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    });




                }

            }

            });



            saveState(fswitch,"FAN");
            saveState(lswitch,"LOCK");
            saveState(bswitch,"BULB");



//        ImageView image = (ImageView)findViewById(R.id.fanimage);
//        TextView l = findViewById(R.id.Label);
//        GetData(l);

//        fanmenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                image.setImageResource(R.drawable.down);
//
//            }
//        });

    }



    public void saveState(SwitchMaterial sw, String app)
    {
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(sw.isChecked() == true)
                {
                    mDatabase.child(acpin).child(app).child("STATE").setValue("ON");
                }
                else
                {
                    mDatabase.child(acpin).child(app).child("STATE").setValue("OFF");
                }

            }
        });
    }


    public void setSwitch(String app, SwitchMaterial sw, LinearLayout lin, ImageView img,int id,int idw)
    {
    if(app.equals("OFF"))
    {
        sw.setChecked(false);
        lin.setBackgroundResource(0);
        img.setImageResource(id);
    }
    else if (app.equals("ON"))
    {
        sw.setChecked(true);
        lin.setBackgroundResource(R.drawable.btn);
        img.setImageResource(idw);

    }}








}