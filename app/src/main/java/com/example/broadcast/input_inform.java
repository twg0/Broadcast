package com.example.broadcast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

public class input_inform extends AppCompatActivity implements View.OnClickListener {

    ImageButton info_input;
    EditText name,birth,phone;
    int village = 0;

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_inform);

        info_input = findViewById(R.id.info_input);
        info_input.setOnClickListener(this);

        //입력된 정보
        name = (EditText) findViewById(R.id.input_name);
        birth = (EditText) findViewById(R.id.input_birth);
        phone = (EditText) findViewById(R.id.input_phone);
    }

    @Override
    public void onClick(View v) {
        if(v == info_input){
            Intent intent;
            if(village == 0)
            {
                intent = new Intent(getApplicationContext(), village_subscribe.class);
                intent.putExtra("data", 0);
            }
            else if(flag == 0) { // 주민
                intent = new Intent(getApplicationContext(), common.class);
                intent.putExtra("data", 0);
            }
            else if(flag == 1) { // 보호자
                intent = new Intent(getApplicationContext(), common.class);
                intent.putExtra("data", 1);
            }
            else { // 마을 이장
                intent = new Intent(getApplicationContext(),master.class);
                intent.putExtra("data", 2);
            }
            startActivity(intent);
        }
    }
}