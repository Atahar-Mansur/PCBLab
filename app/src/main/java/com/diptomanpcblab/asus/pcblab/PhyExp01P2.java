package com.diptomanpcblab.asus.pcblab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class PhyExp01P2 extends AppCompatActivity {

    TextView forward;
    ImageView back, phy01I01, phy01I02, phy01I011, phy01I021;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phy_exp01_p2);

        forward = findViewById(R.id.forPhy01P2);
        back = findViewById(R.id.backId);
        phy01I01 = findViewById(R.id.phy01I01);
        phy01I02 = findViewById(R.id.phy01I02);
        phy01I011 = findViewById(R.id.phy01I011);
        phy01I021 = findViewById(R.id.phy01I021);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhyExp01P2.this,PhyExp01P3.class);
                startActivity(intent);
            }
        });

        phy01I01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phy01I011.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
            }
        });

        phy01I02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phy01I021.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phy01I011.setVisibility(View.INVISIBLE);
                phy01I021.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
            }
        });
    }
}
