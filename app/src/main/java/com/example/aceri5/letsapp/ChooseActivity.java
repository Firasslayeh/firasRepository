package com.example.aceri5.letsapp;



import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


public class ChooseActivity extends AppCompatActivity {

    public Activity choose_activity_pointer = this;

    public static List<EventActivity> events_list = new ArrayList<>();

    int x = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        for (EventActivity event:events_list){
            ImageButton btn1 = new ImageButton(ChooseActivity.this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(900, 900);
            //btn1.bringToFront();
            //btn1.computeScroll();
            btn1.setImageResource(event.get_icon());
            layout1.addView(btn1, params);
        }

        ImageButton IBAdd0 = (ImageButton) findViewById(R.id.IBAdd0);
        IBAdd0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(choose_activity_pointer,ChooseActivityEdit.class);
                startActivity(intent);
            }
        });
    }
}
