package com.example.broadcast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Person_info extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    int trigger, flag = 0;
    LinearLayout linearLayout1, linearLayout2;
    TextView info_title,info_name,info_device,
            info_relation,info_address,info_phone,info_email,info_regislation;
    Button guard_data,withdrawl,village,guard_set;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);

        guard_data = findViewById(R.id.guard_data);
        guard_data.setOnClickListener(this);

        village = findViewById(R.id.village_modify);
        village.setOnClickListener(this);

        guard_set = findViewById(R.id.guard_setting);
        guard_set.setOnClickListener(this);

        intent = getIntent();
        trigger = intent.getIntExtra("data", 0);

        person_classification(trigger);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View view) {

        if(view == guard_data){
            intent = new Intent(this,state_data.class);
            startActivity(intent);
        }
        else if(view == village) {
            intent = new Intent(this,village_subscribe.class);
            startActivity(intent);
        }
        else if(view == guard_set) {
            EditText phone = new EditText(this);
            TextView setting = new TextView(this);
            phone.setHint("번호 입력 시 다시 로그인이 필요합니다.");
            phone.setInputType(InputType.TYPE_CLASS_PHONE);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("피보호자 번호 입력(- 제외)");
            dlg.setView(phone);
            dlg.setPositiveButton("입력", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    phoneNumber = phone.getText().toString();
                    intent = new Intent(Person_info.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            dlg.show();
        }
    }

    public void person_classification(int c) {
        linearLayout1 = findViewById(R.id.layout1);
        linearLayout2 = findViewById(R.id.layout2);

        info_title = findViewById(R.id.info_title);
        info_name=findViewById(R.id.info_name);
        info_relation=findViewById(R.id.info_relation);
        info_device=findViewById(R.id.info_device);
        info_email=findViewById(R.id.info_email);
        info_address=findViewById(R.id.info_address);

        guard_data = findViewById(R.id.guard_data);
        withdrawl = findViewById(R.id.withdrawl);
        if(c == 0) { // 주민이 본인 정보 확인
            linearLayout2.setVisibility(View.GONE);
            linearLayout1.setVisibility(View.VISIBLE);

            info_title.setText("<내 정보>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.GONE);
            info_device.setVisibility(View.GONE);
            info_email.setVisibility(View.VISIBLE);
            info_address.setVisibility(View.GONE);

            guard_data.setVisibility(View.GONE);
            withdrawl.setVisibility(View.VISIBLE);

        } else if(c == 1) { // 보호자가 본인 정보 확인
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout1.setVisibility(View.VISIBLE);

            info_title.setText("<내 정보>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.VISIBLE);
            info_email.setVisibility(View.VISIBLE);
            info_device.setVisibility(View.GONE);
            info_address.setVisibility(View.GONE);

            info_title=findViewById(R.id.info_title2);
            info_name=findViewById(R.id.info_name2);
            info_relation=findViewById(R.id.info_relation2);
            info_email=findViewById(R.id.info_email);
            info_device=findViewById(R.id.info_device2);
            info_address=findViewById(R.id.info_address2);

            info_title.setText("<피보호자>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.GONE);
            info_email.setVisibility(View.VISIBLE);
            info_device.setVisibility(View.GONE);
            info_address.setVisibility(View.VISIBLE);

            guard_data.setVisibility(View.GONE);
            withdrawl.setVisibility(View.VISIBLE);

        } else if(c == 2) { // 마을 이장이 주민 정보 확인
            linearLayout2.setVisibility(View.GONE);
            linearLayout1.setVisibility(View.VISIBLE);

            info_title.setText("<주민>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.GONE);
            info_device.setVisibility(View.GONE);
            info_email.setVisibility(View.VISIBLE);
            info_address.setVisibility(View.GONE);

            guard_data.setVisibility(View.VISIBLE);
            withdrawl.setVisibility(View.GONE);

        } else if(c == 3) { // 마을 이장이 보호자 정보 확인
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout1.setVisibility(View.VISIBLE);

            info_title.setText("<보호자>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.VISIBLE);
            info_email.setVisibility(View.VISIBLE);
            info_device.setVisibility(View.GONE);
            info_address.setVisibility(View.GONE);

            info_title=findViewById(R.id.info_title2);
            info_name=findViewById(R.id.info_name2);
            info_relation=findViewById(R.id.info_relation2);
            info_email=findViewById(R.id.info_email);
            info_device=findViewById(R.id.info_device2);
            info_address=findViewById(R.id.info_address2);

            info_title.setText("<피보호자>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.GONE);
            info_email.setVisibility(View.GONE);
            info_device.setVisibility(View.VISIBLE);
            info_address.setVisibility(View.VISIBLE);

            guard_data.setVisibility(View.VISIBLE);
            withdrawl.setVisibility(View.GONE);

        } else if(c == 4) { // 마을 이장이 단말기 정보 확인
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout1.setVisibility(View.VISIBLE);

            info_title.setText("<단말기>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.GONE);
            info_email.setVisibility(View.GONE);
            info_device.setVisibility(View.VISIBLE);
            info_address.setVisibility(View.VISIBLE);

            info_title=findViewById(R.id.info_title2);
            info_name=findViewById(R.id.info_name2);
            info_relation=findViewById(R.id.info_relation2);
            info_email=findViewById(R.id.info_email);
            info_device=findViewById(R.id.info_device2);
            info_address=findViewById(R.id.info_address2);

            info_title.setText("<보호자>");
            info_name.setVisibility(View.VISIBLE);
            info_relation.setVisibility(View.VISIBLE);
            info_email.setVisibility(View.VISIBLE);
            info_device.setVisibility(View.GONE);
            info_address.setVisibility(View.GONE);

            guard_data.setVisibility(View.VISIBLE);
            withdrawl.setVisibility(View.GONE);
        }
    }
}