package com.example.project_cuoi_ki;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Living_Room extends AppCompatActivity {
    ImageView TV_icon,Lamp_icon,Camera_icon;
    Switch sw_TV, sw_Lamp, sw_Camera;
    boolean stateTV=false;
    boolean stateLamp=false;
    boolean stateCamera=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livingroom);
        TV_icon=findViewById(R.id.tiviicon);
        Lamp_icon=findViewById(R.id.lampicon);
        Camera_icon=findViewById(R.id.cameraicon);
        sw_TV=findViewById(R.id.swTivi);
        sw_Lamp=findViewById(R.id.swLamp);
        sw_Camera=findViewById(R.id.swCamera);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference TV=database.getReference("Living_TV");
        final DatabaseReference Lamp=database.getReference("Living_Lamp");
        final DatabaseReference Camera=database.getReference("Living_Camera");

//điều khiển on off của TV
        //firebase thay đổi làm tv on off
        TV.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if(value.equals("ON")){
                    stateTV=true; //bật TV
                    TV_icon.setImageResource(R.drawable.tv_on);
                    sw_TV.setChecked(true);
                }
                else if(value.equals("OFF")){
                    stateTV=false; //tắt TV
                    TV_icon.setImageResource(R.drawable.tv_off);
                    sw_TV.setChecked(false);
                }
                //switch thay đổi tv on off
                sw_TV.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            stateTV=true;
                            TV_icon.setImageResource(R.drawable.tv_on);
                            TV.setValue("ON");
                        }
                        else {
                            stateTV=false;
                            TV_icon.setImageResource(R.drawable.tv_off);
                            TV.setValue("OFF");
                        }
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//điều khiển on off của lamp
        //firebase thay đổi làm lamp on off
        Lamp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if(value.equals("ON")){
                    stateLamp=true; //bật TV
                    Lamp_icon.setImageResource(R.drawable.living_lamp_on);
                    sw_Lamp.setChecked(true);
                }
                else if(value.equals("OFF")){
                    stateLamp=false; //tắt TV
                    Lamp_icon.setImageResource(R.drawable.ceilinglamp);
                    sw_Lamp.setChecked(false);
                }
                //switch thay đổi Lamp on off
                sw_Lamp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            stateLamp=true;
                            Lamp_icon.setImageResource(R.drawable.living_lamp_on);
                            Lamp.setValue("ON");
                        }
                        else {
                            stateLamp=false;
                            Lamp_icon.setImageResource(R.drawable.ceilinglamp);
                            Lamp.setValue("OFF");
                        }
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//điều khiển on off của camera
        //firebase thay đổi làm camera on off
        Camera.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if(value.equals("ON")){
                    stateCamera=true; //bật TV
                    Camera_icon.setImageResource(R.drawable.living_camera_on);
                    sw_Camera.setChecked(true);
                }
                else if(value.equals("OFF")){
                    stateCamera=false; //tắt TV
                    Camera_icon.setImageResource(R.drawable.camera);
                    sw_Camera.setChecked(false);
                }
                //switch thay đổi camera on off
                sw_Camera.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            stateCamera=true;
                            Camera_icon.setImageResource(R.drawable.living_camera_on);
                            Camera.setValue("ON");
                        }
                        else {
                            stateCamera=false;
                            Camera_icon.setImageResource(R.drawable.camera);
                            Camera.setValue("OFF");
                        }
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
