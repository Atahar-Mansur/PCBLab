package com.diptomanpcblab.asus.pcblab;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class PhyExp01P4 extends AppCompatActivity {

    TextView start, verniar, take_value, command, next;
    ImageView slide_small, thing_small, slide, board, var_main, var_away, var1, var2, var3, turn, back, var;
    int i=1, exp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phy_exp01_p4);

        start = findViewById(R.id.forPhy01P1);
        verniar = findViewById(R.id.forPhy01P2);
        take_value = findViewById(R.id.forPhy01P3);
        command = findViewById(R.id.cmdId);

        slide_small = findViewById(R.id.phy01ex01);
        thing_small = findViewById(R.id.phy01ex02);
        slide = findViewById(R.id.phy01ex03);
        var_main = findViewById(R.id.phy01ex041);
        var_away = findViewById(R.id.phy01ex045);
        var1 = findViewById(R.id.phy01ex042);
        var2 = findViewById(R.id.phy01ex043);
        var3 = findViewById(R.id.phy01ex044);
        turn = findViewById(R.id.phy01ex05);
        var = findViewById(R.id.phy01ex06);
        board = findViewById(R.id.boardId);
        back = findViewById(R.id.backId);
        next = findViewById(R.id.nextId);

        slide_small.setOnLongClickListener(longClickListener);
        thing_small.setOnLongClickListener(longClickListener);
        var_main.setOnLongClickListener(longClickListener);
        var_away.setOnLongClickListener(longClickListener);
        var1.setOnLongClickListener(longClickListener);
        var2.setOnLongClickListener(longClickListener);
        var3.setOnLongClickListener(longClickListener);

        board.setOnDragListener(dragListener);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setVisibility(View.INVISIBLE);
                command.setVisibility(View.VISIBLE);
                exp++;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhyExp01P4.this,PhyExp01P5.class);
                startActivity(intent);
            }
        });
        verniar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVisibility(View.VISIBLE);
                if (i==1) back.setVisibility(View.VISIBLE);
                else next.setVisibility(View.VISIBLE);
            }
        });
        turn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==2){
                    thing_small.setImageResource(R.drawable.phy01ex022);
                    command.setText(R.string.phy01_cmd08);
                }
                if (i==3){
                    thing_small.setImageResource(R.drawable.phy01ex023);
                    command.setText(R.string.phy01_cmd13);
                }
                turn.setVisibility(View.INVISIBLE);
                exp++;
            }
        });
        take_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==2) var.setImageResource(R.drawable.phy01re01);
                if (i==3) var.setImageResource(R.drawable.phy01re02);
                if (i==4) var.setImageResource(R.drawable.phy01re03);
                var.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
                verniar.setVisibility(View.INVISIBLE);
                take_value.setVisibility(View.INVISIBLE);
                if (i==1)command.setText(R.string.phy01_cmd03);
                if (i==2)command.setText(R.string.phy01_cmd06);
                if (i==3)command.setText(R.string.phy01_cmd10);
                if (i==4){
                    command.setText(R.string.phy01_cmd15);
                    verniar.setVisibility(View.VISIBLE);
                    verniar.setText(R.string.final_result);
                    var.setImageResource(R.drawable.phy01re04);
                }
                exp++;
            }
        });
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int drag_event = dragEvent.getAction();

            switch (drag_event){
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
                case DragEvent.ACTION_DROP:
                    final View v = (View) dragEvent.getLocalState();

                    if (v == slide_small && exp==1){
                        slide.setVisibility(View.VISIBLE);
                        var_main.setVisibility(View.VISIBLE);
                        verniar.setVisibility(View.VISIBLE);
                        command.setText(R.string.phy01_cmd02);
                        exp++;
                    }
                    if (v == var_main){
                        var_away.setVisibility(View.VISIBLE);
                        var_main.setVisibility(View.INVISIBLE);
                        command.setText(R.string.phy01_cmd04);
                        exp++;
                    }
                    if (v == thing_small){
                        if (i==1){
                            slide.setImageResource(R.drawable.phy01ex032);
                            exp++;
                        }
                        if (i==2){
                            slide.setImageResource(R.drawable.phy01ex033);
                            exp++;
                        }
                        if (i==3){
                            slide.setImageResource(R.drawable.phy01ex034);
                            exp++;
                        }
                        command.setText(R.string.phy01_cmd05);
                    }
                    if (v == var_away&&i==1){
                        var_away.setVisibility(View.INVISIBLE);
                        var1.setVisibility(View.VISIBLE);
                        take_value.setVisibility(View.VISIBLE);
                        i=2;
                    }
                    else if (v == var_away&&i==2){
                        var_away.setVisibility(View.INVISIBLE);
                        var2.setVisibility(View.VISIBLE);
                        take_value.setVisibility(View.VISIBLE);
                        i=3;
                    }
                    else if (v == var_away&&i==3){
                        var_away.setVisibility(View.INVISIBLE);
                        var3.setVisibility(View.VISIBLE);
                        take_value.setVisibility(View.VISIBLE);
                        i=4;
                    }
                    if (v == var1){
                        slide.setImageResource(R.drawable.phy01ex031);
                        var_away.setVisibility(View.VISIBLE);
                        turn.setVisibility(View.VISIBLE);
                        var1.setVisibility(View.INVISIBLE);
                        command.setText(R.string.phy01_cmd07);
                        exp++;
                    }

                    if (v == var2){
                        slide.setImageResource(R.drawable.phy01ex031);
                        var_away.setVisibility(View.VISIBLE);
                        turn.setVisibility(View.VISIBLE);
                        var2.setVisibility(View.INVISIBLE);
                        command.setText(R.string.phy01_cmd12);
                        exp++;
                    }

                    break;
            }
            return true;
        }
    };
}
