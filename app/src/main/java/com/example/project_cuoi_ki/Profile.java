package com.example.project_cuoi_ki;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    ImageView img;
    EditText name_profile, email_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        img = findViewById(R.id.img_ava);
        name_profile = findViewById(R.id.name_profile);
        email_profile = findViewById(R.id.email_profile);

        showUser();
    }
    private void showUser(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user ==null){
            return;
        }
        String name = user.getDisplayName();
        String email = user.getDisplayName();
        Uri photoURL = user.getPhotoUrl();

        name_profile.setText(name);
        email_profile.setText(email);
    }
}
