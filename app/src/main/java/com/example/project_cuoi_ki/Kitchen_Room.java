package com.example.project_cuoi_ki;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Kitchen_Room extends AppCompatActivity {
    TextView tv_seekbarfridge;
    SeekBar seekbarfridge;
    ImageView Fridge_icon,Light_icon,Exhaust_icon;
    Switch sw_Fridge,sw_Light,sw_Exhaust;
    Boolean stateFridge=false;
    Boolean stateLight=false;
    Boolean stateExhaust=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchenroom);
        init();
        seekbarfridge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_seekbarfridge.setText("" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Fridge_icon = findViewById(R.id.imagefridge);
        Light_icon = findViewById(R.id.lighticon);
        Exhaust_icon = findViewById(R.id.exhausticon);
        sw_Fridge = findViewById(R.id.switchfridge);
        sw_Light = findViewById(R.id.swLight);
        sw_Exhaust = findViewById(R.id.swExhaust);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference Fridge = database.getReference("Kitchen_Fridge");
        final DatabaseReference Light = database.getReference("Kitchen_Light");
        final DatabaseReference Exhaust = database.getReference("Kitchen_Exhaust");

//điều khiển on off của Fridge
        //firebase thay đổi làm Fridge on off
        Fridge.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.equals("ON")) {
                    stateFridge = true; //bật TV
                    Fridge_icon.setImageResource(R.drawable.kitchen_fridge_on);
                    sw_Fridge.setChecked(true);
                } else if (value.equals("OFF")) {
                    stateFridge = false; //tắt TV
                    Fridge_icon.setImageResource(R.drawable.fridge);
                    sw_Fridge.setChecked(false);
                }
                //switch thay đổi Fridge on off
                sw_Fridge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            stateFridge = true;
                            Fridge_icon.setImageResource(R.drawable.kitchen_fridge_on);
                            Fridge.setValue("ON");
                        } else {
                            stateFridge = false;
                            Fridge_icon.setImageResource(R.drawable.fridge);
                            Fridge.setValue("OFF");
                        }
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//điều khiển on off của Light
        //firebase thay đổi làm Light on off
        Light.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.equals("ON")) {
                    stateLight = true; //bật TV
                    Light_icon.setImageResource(R.drawable.kitchen_light_on);
                    sw_Light.setChecked(true);
                } else if (value.equals("OFF")) {
                    stateLight = false; //tắt TV
                    Light_icon.setImageResource(R.drawable.countertop);
                    sw_Light.setChecked(false);
                }
                //switch thay đổi Light on off
                sw_Light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            stateLight = true;
                            Light_icon.setImageResource(R.drawable.kitchen_light_on);
                            Light.setValue("ON");
                        } else {
                            stateLight = false;
                            Light_icon.setImageResource(R.drawable.countertop);
                            Light.setValue("OFF");
                        }
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//điều khiển on off của Exhaust
        //firebase thay đổi làm Exhaust on off
        Exhaust.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.equals("ON")) {
                    stateExhaust = true; //bật TV
                    Exhaust_icon.setImageResource(R.drawable.kitchen_exhaust_on);
                    sw_Exhaust.setChecked(true);
                } else if (value.equals("OFF")) {
                    stateExhaust = false; //tắt TV
                    Exhaust_icon.setImageResource(R.drawable.exhaust);
                    sw_Exhaust.setChecked(false);
                }
                //switch thay đổi Exhaust on off
                sw_Exhaust.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            stateExhaust = true;
                            Exhaust_icon.setImageResource(R.drawable.kitchen_exhaust_on);
                            Exhaust.setValue("ON");
                        } else {
                            stateExhaust = false;
                            Exhaust_icon.setImageResource(R.drawable.exhaust);
                            Exhaust.setValue("OFF");
                        }
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void init(){
        tv_seekbarfridge = findViewById(R.id.tv_seekbarfridge);
        seekbarfridge = findViewById(R.id.seekBarfridge);
    }
}
