package com.diptomanpcblab.asus.pcblab;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class Home extends AppCompatActivity {

    ProgressBar progressBar;
    ImageButton start, option, about;
    int prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        progressBar = findViewById(R.id.progressBarId);
        start = findViewById(R.id.startId);
        option = findViewById(R.id.optionId);
        about = findViewById(R.id.aboutId);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Menu.class);
                startActivity(intent);
                finish();
            }
        });

        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,Option.class);
                startActivity(intent);
                finish();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this,About.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        String flag = intent.getStringExtra("flag");

        if (flag.equals("off")){
            progressBar.setVisibility(View.INVISIBLE);
            start.setVisibility(View.VISIBLE);
            option.setVisibility(View.VISIBLE);
            about.setVisibility(View.VISIBLE);
        }
        else {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dowork();
                }
            });
            thread.start();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    visibiity();
                }
            }, 3000);
        }
    }

    private void dowork(){
        for (prog=20;prog<=100;prog+=20){
            try {
                Thread.sleep(500);
                progressBar.setProgress(prog);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void visibiity() {
        try {
            Thread.sleep(500);
            progressBar.setVisibility(View.INVISIBLE);
            start.setVisibility(View.VISIBLE);
            option.setVisibility(View.VISIBLE);
            about.setVisibility(View.VISIBLE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setMessage("Do you want to exit !!!").setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alart = builder.create();
        alart.show();
    }
}
