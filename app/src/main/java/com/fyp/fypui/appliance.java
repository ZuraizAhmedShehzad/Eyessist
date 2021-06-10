package com.fyp.fypui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class appliance extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener , View.OnClickListener {
    LinearLayout left;
    LinearLayout right;
    LinearLayout up;
    LinearLayout down;
    ImageView item1;
    String pos;
    String bulbp,fanp,nilp,lockp;
    boolean bulbc = false,fanc = false,nilc=false ,lockc=false;
    private DatabaseReference mDatabase;
    FirebaseAuth fAuth;
    private String acpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance);
        left= (LinearLayout) findViewById(R.id.L);
        right= (LinearLayout) findViewById(R.id.R);
        up= (LinearLayout) findViewById(R.id.U);
        down= (LinearLayout) findViewById(R.id.D);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        up.setOnClickListener(this);
        down.setOnClickListener(this);




        mDatabase = FirebaseDatabase.getInstance().getReference();
        fAuth = FirebaseAuth.getInstance();


        mDatabase.child(fAuth.getCurrentUser().getUid().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    acpin = String.valueOf(task.getResult().getValue());


                    mDatabase.child(acpin).child("BULB").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (!task.isSuccessful()) {
                                Log.e("firebase", "Error getting data", task.getException());
                            }
                            else {
                                bulbp = String.valueOf(task.getResult().getValue());
                                if(!bulbp.equals("NONE")) {
                                    bulbc = true;

                                    if(bulbp.equals("RIGHT")) {
                                        item1 = findViewById(R.id.view2);
                                        item1.setImageResource(R.drawable.tv);
                                    }
                                    else if(bulbp.equals("LEFT")) {

                                        item1 = findViewById(R.id.view1);
                                        item1.setImageResource(R.drawable.tv);
                                    }
                                    else if(bulbp.equals("UP")) {
                                        item1 = findViewById(R.id.view3);
                                        item1.setImageResource(R.drawable.tv);
                                    }
                                    else if(bulbp.equals("DOWN")) {
                                        item1 = findViewById(R.id.view4);
                                        item1.setImageResource(R.drawable.tv);
                                    }   }

                            }
                        }
                    });


                    mDatabase.child(acpin).child("FAN").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (!task.isSuccessful()) {
                                Log.e("firebase", "Error getting data", task.getException());
                            }
                            else {
                                fanp = String.valueOf(task.getResult().getValue());
                                if(!fanp.equals("NONE")) {
                                    fanc = true;

                                    if(fanp.equals("RIGHT")) {
                                        item1 = findViewById(R.id.view2);
                                        item1.setImageResource(R.drawable.fan);
                                    }
                                    else if(fanp.equals("LEFT")) {

                                        item1 = findViewById(R.id.view1);
                                        item1.setImageResource(R.drawable.fan);
                                    }
                                    else if(fanp.equals("UP")) {
                                        item1 = findViewById(R.id.view3);
                                        item1.setImageResource(R.drawable.fan);
                                    }
                                    else if(fanp.equals("DOWN")) {
                                        item1 = findViewById(R.id.view4);
                                        item1.setImageResource(R.drawable.fan);
                                    }   }

                            }
                        }
                    });


                    mDatabase.child(acpin).child("LOCK").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (!task.isSuccessful()) {
                                Log.e("firebase", "Error getting data", task.getException());
                            }
                            else {
                                lockp = String.valueOf(task.getResult().getValue());
                                if(!lockp.equals("NONE")) {
                                    lockc = true;

                                    if(lockp.equals("RIGHT")) {
                                        item1 = findViewById(R.id.view2);
                                        item1.setImageResource(R.drawable.blind);
                                    }
                                    else if(lockp.equals("LEFT")) {

                                        item1 = findViewById(R.id.view1);
                                        item1.setImageResource(R.drawable.blind);
                                    }
                                    else if(lockp.equals("UP")) {
                                        item1 = findViewById(R.id.view3);
                                        item1.setImageResource(R.drawable.blind);
                                    }
                                    else if(lockp.equals("DOWN")) {
                                        item1 = findViewById(R.id.view4);
                                        item1.setImageResource(R.drawable.blind);
                                    }   }

                            }
                        }
                    });

                    mDatabase.child(acpin).child("NIL").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (!task.isSuccessful()) {
                                Log.e("firebase", "Error getting data", task.getException());
                            }
                            else {
                                nilp = String.valueOf(task.getResult().getValue());
                                if(!nilp.equals("NONE")) {
                                    nilc = true;

                                    if(nilp.equals("RIGHT")) {
                                        item1 = findViewById(R.id.view2);
                                        item1.setImageResource(R.drawable.light);
                                    }
                                    else if(nilp.equals("LEFT")) {

                                        item1 = findViewById(R.id.view1);
                                        item1.setImageResource(R.drawable.light);
                                    }
                                    else if(nilp.equals("UP")) {
                                        item1 = findViewById(R.id.view3);
                                        item1.setImageResource(R.drawable.light);
                                    }
                                    else if(nilp.equals("DOWN")) {
                                        item1 = findViewById(R.id.view4);
                                        item1.setImageResource(R.drawable.light);
                                    }   }

                            }
                        }
                    });



                }
            }
        });



//



//        mDatabase.child(acpin).child("FAN").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//
//                fanp = String.valueOf(task.getResult().getValue());
//            }
//        });
//        mDatabase.child(acpin).child("LOCK").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//
//                lockp = String.valueOf(task.getResult().getValue());
//            }
//        });
//        mDatabase.child(acpin).child("NIL").child("POSITION").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//
//                nilp = String.valueOf(task.getResult().getValue());
//            }
//        });


//            if(bulbp.equals("RIGHT")) {
//                item1 = findViewById(R.id.view2);
//                item1.setImageResource(R.drawable.tv);
//            }
//            if(bulbp.equals("LEFT")) {
//
//                item1 = findViewById(R.id.view1);
//                item1.setImageResource(R.drawable.tv);
//            }
//            else if(bulbp.equals("UP")) {
//                item1 = findViewById(R.id.view3);
//                item1.setImageResource(R.drawable.tv);
//            }
//            else if(bulbp.equals("DOWN")) {
//                item1 = findViewById(R.id.view4);
//                item1.setImageResource(R.drawable.tv);
//            }
//        }
//        if(fanp != "NONE")
//        {
//            fanc = true;
//            item1.setImageResource(R.drawable.fan);
//        }
//        if(lockp != "NONE")
//        {
//            lockc = true;
//            item1.setImageResource(R.drawable.blind);
//        }
//        if(nilp != "NONE")
//        {
//            nilc = true;
//            item1.setImageResource(R.drawable.light);
//        }








    }








    public void appliance_list(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.appliance_list);
        popup.show();

    }
    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.L)
        {
            item1 = findViewById(R.id.view1);
            appliance_list(v);
            pos="LEFT";
        }
        else if (v.getId()==R.id.R)
        {
            item1 = findViewById(R.id.view2);
            appliance_list(v);
            pos="RIGHT";
        }
        else if (v.getId()==R.id.U)
        {
            item1 = findViewById(R.id.view3);
            appliance_list(v);
            pos="UP";
        }
        else if (v.getId()==R.id.D)
        {
            item1 = findViewById(R.id.view4);
            appliance_list(v);
            pos="DOWN";
        }
    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
                    case R.id.item1:

                        if(bulbc == false){
                        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.tv);
                        bulbp = pos;
                        bulbc = true;
                        mDatabase.child(acpin).child("BULB").child("POSITION").setValue(bulbp);}
                        else
                        {
                            Toast.makeText(this, "Bulb is already selected.", Toast.LENGTH_SHORT).show();
                        }

                        return true;
                    case R.id.item2:
                        if(fanc == false){
                        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.fan);
                            fanp = pos;
                            fanc = true;
                            mDatabase.child(acpin).child("FAN").child("POSITION").setValue(fanp);}
                        else
                        {
                            Toast.makeText(this, "Fan is already selected.", Toast.LENGTH_SHORT).show();
                        }


                        return true;
                    case R.id.item3:
                        if(lockc == false){
                        Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.blind);
                            lockp = pos;
                            lockc = true;
                            mDatabase.child(acpin).child("LOCK").child("POSITION").setValue(lockp);}
                        else
                        {
                            Toast.makeText(this, "Lock is already selected.", Toast.LENGTH_SHORT).show();
                        }

                        return true;

                    case R.id.item4:
                        if(nilc == false){
                        Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.light);

                            nilp = pos;
                            nilc = true;
                            mDatabase.child(acpin).child("NIL").child("POSITION").setValue(nilp);}
                        else
                        {
                            Toast.makeText(this, "Nil is already selected.", Toast.LENGTH_SHORT).show();
                        }

                        return true;


                    case R.id.item5:
                        Toast.makeText(this, "RESET", Toast.LENGTH_SHORT).show();
                        switch(pos){
                            case "LEFT":
                                if(bulbc == true && bulbp.equals("LEFT"))
                                {
                                    mDatabase.child(acpin).child("BULB").child("POSITION").setValue("NONE");
                                    bulbc = false;
                                }
                                else if(fanc == true && fanp.equals("LEFT"))
                                {
                                    mDatabase.child(acpin).child("FAN").child("POSITION").setValue("NONE");
                                    fanc = false;
                                }
                                else if(lockc == true && lockp.equals("LEFT"))
                                {
                                    mDatabase.child(acpin).child("LOCK").child("POSITION").setValue("NONE");
                                    lockc = false;
                                }
                                else if(nilc == true && nilp.equals("LEFT"))
                                {
                                    mDatabase.child(acpin).child("NIL").child("POSITION").setValue("NONE");
                                    nilc = false;
                                }

                                item1.setImageResource(R.drawable.left);
                                return true;
                            case "RIGHT":
                                if(bulbc == true && bulbp.equals("RIGHT"))
                                {
                                    mDatabase.child(acpin).child("BULB").child("POSITION").setValue("NONE");
                                    bulbc = false;
                                }
                                else if(fanc == true && fanp.equals("RIGHT"))
                                {
                                    mDatabase.child(acpin).child("FAN").child("POSITION").setValue("NONE");
                                    fanc = false;
                                }
                                else if(lockc == true && lockp.equals("RIGHT"))
                                {
                                    mDatabase.child(acpin).child("LOCK").child("POSITION").setValue("NONE");
                                    lockc = false;
                                }
                                else if(nilc == true && nilp.equals("RIGHT"))
                                {
                                    mDatabase.child(acpin).child("NIL").child("POSITION").setValue("NONE");
                                    nilc = false;
                                }
                                item1.setImageResource(R.drawable.right);
                                return true;
                            case "UP":
                                if(bulbc == true && bulbp.equals("UP"))
                                {
                                    mDatabase.child(acpin).child("BULB").child("POSITION").setValue("NONE");
                                    bulbc = false;
                                }
                                else if(fanc == true && fanp.equals("UP"))
                                {
                                    mDatabase.child(acpin).child("FAN").child("POSITION").setValue("NONE");
                                    fanc = false;
                                }
                                else if(lockc == true && lockp.equals("UP"))
                                {
                                    mDatabase.child(acpin).child("LOCK").child("POSITION").setValue("NONE");
                                    lockc = false;
                                }
                                else if(nilc == true && nilp.equals("UP"))
                                {
                                    mDatabase.child(acpin).child("NIL").child("POSITION").setValue("NONE");
                                    nilc = false;
                                }
                                item1.setImageResource(R.drawable.up);
                                return true;
                            case "DOWN":
                                if(bulbc == true && bulbp.equals("DOWN"))
                                {
                                    mDatabase.child(acpin).child("BULB").child("POSITION").setValue("NONE");
                                    bulbc = false;
                                }
                                else if(fanc == true && fanp.equals("DOWN"))
                                {
                                    mDatabase.child(acpin).child("FAN").child("POSITION").setValue("NONE");
                                    fanc = false;
                                }
                                else if(lockc == true && lockp.equals("DOWN"))
                                {
                                    mDatabase.child(acpin).child("LOCK").child("POSITION").setValue("NONE");
                                    lockc = false;
                                }
                                else if(nilc == true && nilp.equals("DOWN"))
                                {
                                    mDatabase.child(acpin).child("NIL").child("POSITION").setValue("NONE");
                                    nilc = false;
                                }
                                item1.setImageResource(R.drawable.down);
                                return true;

                            default:
                                return false;


                        }


                    default:
                        return false;
                }
            }


            }





