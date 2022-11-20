package com.example.project_cuoi_ki;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Kitchen_Room extends AppCompatActivity {
    TextView tv_seekbarfridge;
    SeekBar seekbarfridge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchenroom);
        init();
        seekbarfridge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv_seekbarfridge.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    private void init(){
        tv_seekbarfridge = findViewById(R.id.tv_seekbarfridge);
        seekbarfridge = findViewById(R.id.seekBarfridge);
    }
}
