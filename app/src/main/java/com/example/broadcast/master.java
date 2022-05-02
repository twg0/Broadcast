package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class master extends AppCompatActivity implements View.OnClickListener{

    Button notice;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        notice = findViewById(R.id.notice);
        notice.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if(view == notice) {
            intent = new Intent(this,broadcast_notice.class);
            intent.putExtra("data",2);
            startActivity(intent);
        }
    }
}