package com.diptomanpcblab.asus.pcblab;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class PhyExp02P4 extends AppCompatActivity {

    TextView start, verniar, take_value, command, next;
    ImageView slide_small, thing_small, slide, board, pointer, back, var;
    AnimationDrawable anim1, anim2;
    int i=1, exp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_phy_exp02_p4);

        start = findViewById(R.id.forPhy01P1);
        verniar = findViewById(R.id.forPhy01P2);
        take_value = findViewById(R.id.forPhy01P3);
        command = findViewById(R.id.cmdId);
        next = findViewById(R.id.nextId);

        slide_small = findViewById(R.id.phy01ex01);
        thing_small = findViewById(R.id.phy01ex02);
        slide = findViewById(R.id.phy01ex03);
        board = findViewById(R.id.boardId);
        back = findViewById(R.id.backId);
        var = findViewById(R.id.phy01ex06);
        pointer = findViewById(R.id.down_pointer);

        slide_small.setOnLongClickListener(longClickListener);
        thing_small.setOnLongClickListener(longClickListener);

        board.setOnDragListener(dragListener);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start.setVisibility(View.INVISIBLE);
                command.setVisibility(View.VISIBLE);
                exp=1;
            }
        });
        verniar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVisibility(View.VISIBLE);
                if (i==1||i==2) back.setVisibility(View.VISIBLE);
                else next.setVisibility(View.VISIBLE);
            }
        });
        take_value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setImageResource(R.drawable.phy02ex07);
                var.setVisibility(View.VISIBLE);
                take_value.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhyExp02P4.this,PhyExp02P5.class);
                startActivity(intent);
            }
        });

        pointer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pointer.setVisibility(View.INVISIBLE);
                if(exp==4)
                {
                    slide.setImageResource(R.drawable.phy02ex03);
                    anim1 = (AnimationDrawable) slide.getDrawable();
                    anim1.start();
                    command.setText(R.string.phy02_cmd05);
                    pointer.setImageResource(R.drawable.up_pointer);
                    exp = 5;
                }
                else if(exp==6)
                {
                    slide.setImageResource(R.drawable.phy02ex04);
                    anim1 = (AnimationDrawable) slide.getDrawable();
                    anim1.start();
                    command.setText(R.string.phy02_cmd07);
                    take_value.setVisibility(View.VISIBLE);
                    exp = 7;
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                var.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
                if (i==1)
                {
                    verniar.setText(R.string.minimum_calculation);
                    command.setText(R.string.phy02_cmd03);
                    var.setImageResource(R.drawable.phy02ex06);
                    exp=3;
                }
                if (i==2)
                {
                    verniar.setVisibility(View.INVISIBLE);
                    pointer.setVisibility(View.VISIBLE);
                    command.setText(R.string.phy02_cmd04);
                    exp=4;
                }
                if (i==3)
                {
                    verniar.setText(R.string.final_result);
                    verniar.setVisibility(View.VISIBLE);
                    command.setText(R.string.phy02_cmd08);
                    var.setImageResource(R.drawable.phy02ex08);
                    exp=8;
                }
                i++;
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
                        verniar.setVisibility(View.VISIBLE);
                        command.setText(R.string.phy02_cmd02);
                        exp=2;
                    }

                    if (v == thing_small && exp==5){
                        slide.setImageResource(R.drawable.phy02ex04f5);
                        command.setText(R.string.phy02_cmd06);
                        pointer.setVisibility(View.VISIBLE);
                        exp=6;
                    }

                    break;
            }
            return true;
        }
    };
}
