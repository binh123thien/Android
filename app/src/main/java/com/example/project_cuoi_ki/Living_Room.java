package com.example.project_cuoi_ki;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Living_Room extends AppCompatActivity {
    ImageView TVicon,Lampicon,Camaraicon;
    Switch swTV, swLamp, swCamera;
    boolean stateTV,stateLamp,stateCamara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livingroom);

        FirebaseDatabase database=FirebaseDatabase.getInstance();

        final DatabaseReference nhietdo=database.getReference("NhietDo");
    }
}
