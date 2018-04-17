package com.diptomanpcblab.asus.pcblab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    ImageButton back_button;
    ImageView physics, chemestry, biology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);

//        back_button = findViewById(R.id.backButtonMenu);
//        back_button.getBackground().setAlpha(1);

        physics = findViewById(R.id.phisicsId);
        chemestry = findViewById(R.id.chemestryId);
        biology = findViewById(R.id.biologyId);


        physics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this,Physics.class);
                startActivity(intent);
            }
        });
        chemestry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this,Chemestry.class);
                startActivity(intent);
            }
        });
        biology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this,Biology.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu.this,Home.class);
        intent.putExtra("flag", "off");
        startActivity(intent);
        finish();
    }
}
