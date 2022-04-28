package com.example.broadcast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class broadcast_notice extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ArrayList<HashMap<String, String>> ti_con;
    ArrayList<String> title, content;
    HashMap<String, String> map;
    String[] ti_data, con_data;
    ListView listView;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_notice);

        listView = findViewById(R.id.broad_list);

        ti_data = getResources().getStringArray(R.array.title);
        con_data = getResources().getStringArray(R.array.content);
        ti_con = new ArrayList<>();

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.broadcast_content,R.id.simple_title,ti_data);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(ti_data[i] + " 방송 내용");
        builder.setMessage(con_data[i]);
        builder.setPositiveButton("확인",null);

        alertDialog = builder.create();
        alertDialog.show();
    }
}