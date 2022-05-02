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

    TextView targetTextView;
    ImageButton info_input;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButton;
    LinearLayout linearLayout;
    EditText name,birth,phone,guard_name,guard_birth,master_id;

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_inform);

        //Check box 이벤트 등록
        checkBox=findViewById(R.id.checkbox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox.setText("is Checked");
                } else {
                    checkBox.setText("is unChecked");
                }
            }
        });
        checkBox.setVisibility(View.GONE);

        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.check(R.id.radio1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.radio1){
                    linearLayout=findViewById(R.id.guard);
                    linearLayout.setVisibility(View.GONE);
                    linearLayout=findViewById(R.id.village_m);
                    linearLayout.setVisibility(View.GONE);
                    flag = 0;
                } else if(checkedId == R.id.radio2) {
                    linearLayout=findViewById(R.id.village_m);
                    linearLayout.setVisibility(View.GONE);
                    linearLayout=findViewById(R.id.guard);
                    linearLayout.setVisibility(View.VISIBLE);
                    flag = 1;
                } else {
                    linearLayout=findViewById(R.id.guard);
                    linearLayout.setVisibility(View.GONE);
                    linearLayout=findViewById(R.id.village_m);
                    linearLayout.setVisibility(View.VISIBLE);
                    flag = 2;
                }
            }
        });
        info_input = findViewById(R.id.info_input);
        info_input.setOnClickListener(this);

        //입력된 정보
        name = (EditText) findViewById(R.id.input_name);
        birth = (EditText) findViewById(R.id.input_birth);
        phone = (EditText) findViewById(R.id.input_phone);
        guard_name = (EditText) findViewById(R.id.input_guard_name);
        guard_birth = (EditText) findViewById(R.id.input_birth);
        master_id = (EditText) findViewById(R.id.input_master_id);

    }

    @Override
    public void onClick(View v) {
        if(v == info_input){
            Intent intent;
            if(flag == 0) { // 주민
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