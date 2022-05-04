package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class manage_person_delete extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    String[] ti_data;
    ArrayList<Delete_personVO> items;
    Button deleteBtn,closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_person_delete);

        listView = findViewById(R.id.person_list);

        ti_data = getResources().getStringArray(R.array.person);

        items = new ArrayList<Delete_personVO>();
        for(int i =0;i<ti_data.length;i++){
            String s = ti_data[i];
            boolean b = false;
            Delete_personVO item = new Delete_personVO(b,s);
            items.add(item);
        }

        MyAdapter adapter = new MyAdapter(items);
        listView.setAdapter(adapter);

        deleteBtn = findViewById(R.id.delete);
        closeBtn = findViewById(R.id.close);

        deleteBtn.setOnClickListener(this);
        closeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == closeBtn)
            finish();
    }
}
