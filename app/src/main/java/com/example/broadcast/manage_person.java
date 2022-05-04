package com.example.broadcast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class manage_person extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    String[] ti_data;
    ListView listView;
    ImageButton imageButton,trash_bucket;
    Intent intent;
    int trigger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_person);

        listView = findViewById(R.id.person_list);

        ti_data = getResources().getStringArray(R.array.person);

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.broadcast_content,R.id.simple_title,ti_data);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        trigger = intent.getIntExtra("data",0);

        imageButton = findViewById(R.id.plus);
        imageButton.setOnClickListener(this);

        trash_bucket = findViewById(R.id.trash_bucket);
        trash_bucket.setOnClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        intent = new Intent(this,Person_info.class);
        if(ti_data[i].contains("단말기")){
            intent.putExtra("data",4);
        } else {
            intent.putExtra("data",3);
        }
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view == imageButton) {
            intent = new Intent(this,manage_person_plus.class);
            startActivity(intent);
        } else if(view == trash_bucket) {
            intent = new Intent(this,manage_person_delete.class);
            startActivity(intent);
        }
    }
}