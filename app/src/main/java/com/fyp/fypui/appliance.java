package com.fyp.fypui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class appliance extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener , View.OnClickListener {
    Button left;
    Button right;
    Button up;
    Button down;
    ImageView item1;
    String pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance);
        left= (Button) findViewById(R.id.left);
        right= (Button) findViewById(R.id.right);
        up= (Button) findViewById(R.id.up);
        down= (Button) findViewById(R.id.down);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        up.setOnClickListener(this);
        down.setOnClickListener(this);

    }


    public void appliance_list(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.appliance_list);
        popup.show();

    }
    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.left)
        {
            item1 = findViewById(R.id.view1);
            appliance_list(v);
            pos="left";
        }
        else if (v.getId()==R.id.right)
        {
            item1 = findViewById(R.id.view2);
            appliance_list(v);
            pos="right";
        }
        else if (v.getId()==R.id.up)
        {
            item1 = findViewById(R.id.view3);
            appliance_list(v);
            pos="up";
        }
        else if (v.getId()==R.id.down)
        {
            item1 = findViewById(R.id.view4);
            appliance_list(v);
            pos="down";
        }
    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
                    case R.id.item1:
                        item1.setImageResource(R.drawable.tv);
                        Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item2:
                        Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.fan);
                        return true;
                    case R.id.item3:
                        Toast.makeText(this, "ON", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.blind);
                        return true;
                    case R.id.item4:
                        Toast.makeText(this, "hello4", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.light);
                        return true;
                    case R.id.item5:
                        Toast.makeText(this, "hello5", Toast.LENGTH_SHORT).show();
                        item1.setImageResource(R.drawable.door);
                        return true;
                    case R.id.item6:
                        Toast.makeText(this, "RESET", Toast.LENGTH_SHORT).show();
                        switch(pos){
                            case "left":
                                item1.setImageResource(R.drawable.left);
                                return true;
                            case "right":
                                item1.setImageResource(R.drawable.right);
                                return true;
                            case "up":
                                item1.setImageResource(R.drawable.up);
                                return true;
                            case "down":
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





