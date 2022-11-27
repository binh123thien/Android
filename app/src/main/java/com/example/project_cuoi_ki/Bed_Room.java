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

public class Bed_Room extends AppCompatActivity {
    TextView tv_seekbar;
    SeekBar seekbar;
    ImageView TiVi_icon,Lampp_icon,AirConditon_icon;
    Switch sw_TiVi, sw_Lampp, sw_AirConditon;
    boolean stateTiVi=false;
    boolean stateLampp=false;
    boolean stateAirConditon=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bedroom);
        init();

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_seekbar.setText(""+i +"°C");


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TiVi_icon=findViewById(R.id.tvicon);
        Lampp_icon=findViewById(R.id.lampicon);
        AirConditon_icon=findViewById(R.id.imageaircondition);
        sw_TiVi=findViewById(R.id.swTvv);
        sw_Lampp=findViewById(R.id.swlampp);
        sw_AirConditon=findViewById(R.id.switchairconditon);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference TiVi=database.getReference("Bed_TV");
        final DatabaseReference Lampp=database.getReference("Bed_Lamp");
        final DatabaseReference AirConditon=database.getReference("Bed_Air");

//điều khiển on off của TV
        //firebase thay đổi làm tv on off
        TiVi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if(value.equals("ON")){
                    stateTiVi=true; //bật TV
                    TiVi_icon.setImageResource(R.drawable.bed_tv_on);
                    sw_TiVi.setChecked(true);
                }
                else if(value.equals("OFF")){
                    stateTiVi=false; //tắt TV
                    TiVi_icon.setImageResource(R.drawable.monitor);
                    sw_TiVi.setChecked(false);
                }
                //switch thay đổi tv on off
                sw_TiVi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            stateTiVi=true;
                            TiVi_icon.setImageResource(R.drawable.bed_tv_on);
                            TiVi.setValue("ON");
                        }
                        else {
                            stateTiVi=false;
                            TiVi_icon.setImageResource(R.drawable.monitor);
                            TiVi.setValue("OFF");
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
        Lampp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if(value.equals("ON")){
                    stateLampp=true; //bật TV
                    Lampp_icon.setImageResource(R.drawable.bed_light_on);
                    sw_Lampp.setChecked(true);
                }
                else if(value.equals("OFF")){
                    stateLampp=false; //tắt TV
                    Lampp_icon.setImageResource(R.drawable.idea);
                    sw_Lampp.setChecked(false);
                }
                //switch thay đổi Lamp on off
                sw_Lampp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            stateLampp=true;
                            Lampp_icon.setImageResource(R.drawable.bed_light_on);
                            Lampp.setValue("ON");
                        }
                        else {
                            stateLampp=false;
                            Lampp_icon.setImageResource(R.drawable.idea);
                            Lampp.setValue("OFF");
                        }
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//điều khiển on off của airconditon
        //firebase thay đổi làm airconditon on off
        AirConditon.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                if(value.equals("ON")){
                    stateAirConditon=true; //bật TV
                    AirConditon_icon.setImageResource(R.drawable.bed_air_on);
                    sw_AirConditon.setChecked(true);
                }
                else if(value.equals("OFF")){
                    stateAirConditon=false; //tắt TV
                    AirConditon_icon.setImageResource(R.drawable.ac);
                    sw_AirConditon.setChecked(false);
                }
                //switch thay đổi airconditon on off
                sw_AirConditon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if(isChecked) {
                            stateAirConditon=true;
                            AirConditon_icon.setImageResource(R.drawable.bed_air_on);
                            AirConditon.setValue("ON");
                        }
                        else {
                            stateAirConditon=false;
                            AirConditon_icon.setImageResource(R.drawable.ac);
                            AirConditon.setValue("OFF");
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
        tv_seekbar = findViewById(R.id.tv_seekbar);
        seekbar = findViewById(R.id.seekBar);
    }

}