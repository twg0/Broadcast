package com.example.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class broadcast_record extends AppCompatActivity implements View.OnClickListener{

    Dialog dialog;
    Button listen_record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_record);

        dialog = new Dialog(this);       // Dialog 초기화
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        dialog.setContentView(R.layout.dialog_play);             // xml 레이아웃 파일과 연결

        listen_record = findViewById(R.id.listen_record);
        listen_record.setOnClickListener(this);

        // 버튼: 커스텀 다이얼로그 띄우기

    }

    @Override
    public void onClick(View view) {
        if(view == listen_record) {
            showDialog();
        }
    }

    // dialog01을 디자인하는 함수
    public void showDialog(){
        dialog.show(); // 다이얼로그 띄우기

        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        // 위젯 연결 방식은 각자 취향대로~
        // '아래 아니오 버튼'처럼 일반적인 방법대로 연결하면 재사용에 용이하고,
        // '아래 네 버튼'처럼 바로 연결하면 일회성으로 사용하기 편함.
        // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

        // 재생 버튼
        Button playBtn = dialog.findViewById(R.id.playBtn);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현

            }
        });
        // 닫기 버튼
        dialog.findViewById(R.id.closeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                dialog.dismiss(); // 다이얼로그 닫기
            }
        });
    }

}