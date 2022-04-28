package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class common extends AppCompatActivity implements View.OnClickListener{

    Button guard_data,notice;
    ImageButton person_info;
    ImageButton logout;
    int trigger = 0; // 주민(0)과 보호자(1) 구분 플래그

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        Intent intent = getIntent();
        trigger = intent.getIntExtra("data",0);

        guard_data = findViewById(R.id.guard_data);
        if(trigger == 1)
            guard_data.setVisibility(View.VISIBLE); // 보호자일 때
        else
            guard_data.setVisibility(View.INVISIBLE); // 주민일 때
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(this);

        notice = findViewById(R.id.notice);
        notice.setOnClickListener(this);

        person_info = findViewById(R.id.person_info);
        person_info.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        if(view == logout) {

        }
        else if(view == notice ){
            intent = new Intent(this,broadcast_notice.class);
            startActivity(intent);
        } else if (view == person_info) {
            intent = new Intent(this,Person_info.class);
            intent.putExtra("data",trigger);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}