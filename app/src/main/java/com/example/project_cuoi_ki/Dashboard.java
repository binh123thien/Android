package com.example.project_cuoi_ki;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {
    AlertDialog.Builder builderDialog;
    AlertDialog alertDialog;
    ImageView imageliving,imagebed,imagekitchen;
    TextView textliving,textbed,textkitchen;
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


        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeaction:
                        Toast.makeText(Dashboard.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.personaction:
                        Toast.makeText(Dashboard.this, "Alo", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logoutaction:
                        showAlertDialog(R.layout.dialog);
                        break;
                        
                }
                return true;
            }

            private void showAlertDialog(int dialog) {
                builderDialog = new AlertDialog.Builder(Dashboard.this);
                View layoutView = getLayoutInflater().inflate(dialog,null);
                Button btnlogout = layoutView.findViewById(R.id.btnlogout);

                builderDialog.setView(layoutView);
                alertDialog = builderDialog.create();
                alertDialog.show();
                btnlogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });

            }
        });


        // hiển thị thòi gian
        String formatdate = "E,   d-M-yyyy    hh:mm:ss";
        time.setFormat24Hour(formatdate);

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
