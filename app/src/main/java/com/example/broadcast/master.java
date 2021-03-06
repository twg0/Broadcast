package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class master extends AppCompatActivity implements View.OnClickListener{

    Button notice,broadcast,manage_person_button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        notice = findViewById(R.id.notice);
        notice.setOnClickListener(this);

        broadcast = findViewById((R.id.broadcast));
        broadcast.setOnClickListener(this);

        manage_person_button = findViewById(R.id.manage_person_button);
        manage_person_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view == notice) {
            intent = new Intent(this,broadcast_notice.class);
            intent.putExtra("data",2);
            startActivity(intent);
        }
        else if(view == broadcast) {
            intent = new Intent(this,broadcast_record.class);
            startActivity(intent);
        } else if(view == manage_person_button) {
            intent = new Intent(this,manage_person.class);
            intent.putExtra("data",2);
            startActivity(intent);
        }
    }
}