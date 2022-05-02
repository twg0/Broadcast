package com.example.broadcast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class state_data extends AppCompatActivity {

    private LineChart lineChart;
    TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_data);

        ArrayList<Entry> entry_chart1 = new ArrayList<>(); // 데이터를 담을 Arraylist
        ArrayList<Entry> entry_chart2 = new ArrayList<>();
        ArrayList<Entry> entry_chart3 = new ArrayList<>();

        lineChart = (LineChart) findViewById(R.id.chart);

        LineData chartData = new LineData(); // 차트에 담길 데이터

        entry_chart1.add(new Entry(1710, (float) 23.3)); //entry_chart1에 좌표 데이터를 담는다.
        entry_chart1.add(new Entry(1711, (float) 20.2));
        entry_chart1.add(new Entry(1712, (float) 19.2));
        entry_chart1.add(new Entry(1713, (float) 20.4));
        entry_chart1.add(new Entry(1714, (float) 22.8));
        entry_chart1.add(new Entry(1715, (float) 21.9));

        entry_chart2.add(new Entry(1710, (float) 21.3)); //entry_chart1에 좌표 데이터를 담는다.
        entry_chart2.add(new Entry(1711, (float) 29.2));
        entry_chart2.add(new Entry(1712, (float) 28.2));
        entry_chart2.add(new Entry(1713, (float) 25.4));
        entry_chart2.add(new Entry(1714, (float) 23.8));
        entry_chart2.add(new Entry(1715, (float) 19.9));

        entry_chart3.add(new Entry(1710, (float) 26.3)); //entry_chart1에 좌표 데이터를 담는다.
        entry_chart3.add(new Entry(1711, (float) 27.2));
        entry_chart3.add(new Entry(1712, (float) 31.2));
        entry_chart3.add(new Entry(1713, (float) 25.4));
        entry_chart3.add(new Entry(1714, (float) 21.8));
        entry_chart3.add(new Entry(1715, (float) 27.9));

        LineDataSet lineDataSet1 = new LineDataSet(entry_chart1, "Temperature"); // 데이터가 담긴 Arraylist 를 LineDataSet 으로 변환한다.
        LineDataSet lineDataSet2 = new LineDataSet(entry_chart2, "Humidity");
        LineDataSet lineDataSet3 = new LineDataSet(entry_chart3, "Illuminance");

        lineDataSet1.setColor(Color.RED); // 해당 LineDataSet의 색 설정 :: 각 Line 과 관련된 세팅은 여기서 설정한다.
        lineDataSet1.setCircleColor(Color.RED); // 꺾이는 부분 색상
        lineDataSet2.setColor(Color.BLACK);
        lineDataSet2.setCircleColor(Color.BLACK);
        lineDataSet3.setColor(Color.BLUE);
        lineDataSet3.setCircleColor(Color.BLUE);

        chartData.addDataSet(lineDataSet1); // 해당 LineDataSet 을 적용될 차트에 들어갈 DataSet 에 넣는다.
        chartData.addDataSet(lineDataSet2);
        chartData.addDataSet(lineDataSet3);

        XAxis xAxis = lineChart.getXAxis(); // x 축 설정
        xAxis.setPosition(XAxis.XAxisPosition.TOP); //x 축 표시에 대한 위치 설정

        xAxis.setValueFormatter(new ValueFormatter() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public String getFormattedValue(float value) {

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                String now_time = sdf.format(date);
                return now_time;
            }
        });

        YAxis yAxisRight = lineChart.getAxisRight(); //Y축의 오른쪽면 설정
        yAxisRight.setDrawLabels(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawGridLines(false);
        //y축의 활성화를 제거함

        lineChart.setData(chartData); // 차트에 위의 DataSet을 넣는다.

        lineChart.invalidate(); // 차트 업데이트
        lineChart.setTouchEnabled(false); // 차트 터치 disable
        lineChart.setDescription(null);

        textView1 = findViewById(R.id.gas);
        textView2 = findViewById(R.id.earth_quake);
        textView3 = findViewById(R.id.strange_act);

        textView1.setText("이상없음");
        textView2.setText("이상없음");
        textView3.setText("이상없음");
    }
}
