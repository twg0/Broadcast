package com.example.broadcast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class village_subscribe extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener{

    String[] ti_data, con_data;
    ListView listView;
    AlertDialog alertDialog;
    ImageButton imageButton;
    Intent intent;
    int trigger,village;
    public static Context context = village_subscribe.context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_village_subscribe);

        listView = findViewById(R.id.village_list);

        ti_data = getResources().getStringArray(R.array.village);
        con_data = getResources().getStringArray(R.array.village_address);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.village_content,R.id.simple_title,ti_data);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        intent = getIntent();
        trigger = intent.getIntExtra("data",0);

        context = this.getApplicationContext();
    }

    @Override
    public void onClick(View view) {

    }

    // 리스트에서 마을을 선택하면 다이얼로그 발생
    // 등록을 누르면 마을이 등록됨
    // 지금 현재는 village라는 값만 선택되는 형태
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(ti_data[i] + " 방송 내용");
        builder.setMessage(con_data[i]);
        builder.setPositiveButton("등록",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int view) {
                village = i;
                intent = new Intent(village_subscribe.this,common.class);
                startActivity(intent);
                //((village_subscribe)context).finish();
            }
        });
        builder.setNegativeButton("닫기",null);

        alertDialog = builder.create();
        alertDialog.show();
    }
}