package com.diptomanpcblab.asus.pcblab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Physics extends AppCompatActivity {

    private ListView physics_list_view;
    private String[] physics_experiments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_physics);

        physics_list_view = findViewById(R.id.phisicsListId);
        physics_experiments = getResources().getStringArray(R.array.physics_experiments);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Physics.this,
                R.layout.list_design, R.id.listTextId, physics_experiments);
        physics_list_view.setAdapter(adapter);

        physics_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0) Toast.makeText(Physics.this,"Sorry this experiment is locked\nPlease wait for update",
                        Toast.LENGTH_SHORT).show();
                else if (i==0){
                    Intent intent = new Intent(Physics.this,PhyExp01P1.class);
                    startActivity(intent);
                }
            }
        });
    }
}
