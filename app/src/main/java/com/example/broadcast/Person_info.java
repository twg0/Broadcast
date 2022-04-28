package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Person_info extends AppCompatActivity {

    Intent intent;
    int trigger;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        intent = getIntent();
        trigger = intent.getIntExtra("data", 0);

        linearLayout = findViewById(R.id.guard_info);
        if (trigger == 0)
            linearLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}