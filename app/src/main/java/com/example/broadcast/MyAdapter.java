package com.example.broadcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private ArrayList<Delete_personVO> list;

    MyAdapter(ArrayList<Delete_personVO> i) {
        list = i;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public boolean isChecked(int position) {
        return list.get(position).checked;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.person_content, viewGroup, false);
        }
        TextView title = view.findViewById(R.id.simple_person_title);
        CheckBox checkBox = view.findViewById(R.id.person_checkbox);
        checkBox.setChecked(list.get(position).checked);
        title.setText(list.get(position).ItemString);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean newState = !list.get(position).isChecked();
                list.get(position).checked = newState;
            }
        });
        checkBox.setChecked(isChecked(position));
        return view;
    }
}
