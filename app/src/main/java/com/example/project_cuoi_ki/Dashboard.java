package com.example.project_cuoi_ki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Dashboard extends AppCompatActivity {
    ImageView imageliving,imagebed,imagekitchen;
    TextView textliving,textbed,textkitchen,textnhietdo,textdoam;
    TextClock time;
    private static final String TIME_FORMAT_24 = "HH:mm:ss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        imageliving = findViewById(R.id.imagelivingroom);
        imagebed = findViewById(R.id.imagebedroom);
        imagekitchen = findViewById(R.id.imagekitchenroom);
        textliving = findViewById(R.id.textlivingroom);
        textbed = findViewById(R.id.textbedroom);
        textkitchen = findViewById(R.id.textkitchenroom);
        time=findViewById(R.id.texttime);
        textnhietdo = findViewById(R.id.nhiet_do);
        textdoam = findViewById(R.id.do_am);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        // hiển thị thòi gian
        String formatdate = "E,   d-M-yyyy    hh:mm:ss";
        time.setFormat24Hour(formatdate);

        //đọc nhiệt độ, độ ẩm
        final DatabaseReference nhietdo=database.getReference("Room_NhietDo");
        final DatabaseReference doam=database.getReference("Room_DoAm");

        nhietdo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                value = value + "°C";
                textnhietdo.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        doam.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                value = value + "%";
                textdoam.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        // nút nhấn để chuyển tới giao diện living room
        imageliving.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Living_Room.class);
                startActivity(intent);
            }
        });
        textliving.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Living_Room.class);
                startActivity(intent);
            }
        });

        //nut nhấn để chuyển tới bedroom
        imagebed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Bed_Room.class);
                startActivity(intent);
            }
        });
        textbed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Bed_Room.class);
                startActivity(intent);
            }
        });

        //nút nhấn để chuyển tới kitchen room
        imagekitchen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Kitchen_Room.class);
                startActivity(intent);
            }
        });
        textkitchen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Kitchen_Room.class);
                startActivity(intent);
            }
        });
    }
}
