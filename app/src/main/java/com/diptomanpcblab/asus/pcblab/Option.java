package com.diptomanpcblab.asus.pcblab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Option extends AppCompatActivity {

    ImageView mOn, mOff, sOn, sOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_option);

        mOn = findViewById(R.id.musicOnId);
        mOff = findViewById(R.id.musicOffId);
        sOn = findViewById(R.id.soundOnId);
        sOff = findViewById(R.id.soundOffId);

        mOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOn.setVisibility(View.INVISIBLE);
                mOff.setVisibility(View.VISIBLE);
            }
        });
        mOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOn.setVisibility(View.VISIBLE);
                mOff.setVisibility(View.INVISIBLE);
            }
        });
        sOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sOn.setVisibility(View.INVISIBLE);
                sOff.setVisibility(View.VISIBLE);
            }
        });
        sOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sOn.setVisibility(View.VISIBLE);
                sOff.setVisibility(View.INVISIBLE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Option.this,Home.class);
        intent.putExtra("flag", "off");
        startActivity(intent);
        finish();
    }
}
