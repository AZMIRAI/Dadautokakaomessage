package com.example.dadautokakaomessage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {



TextView textView,textView2,textView3;


// 데이터를 배열에 넣어서 준비
    String[] items = {"오전","오후"};

    String[] items2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

    String[] items3 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        // API에 만들어져있는 R.layout.simple_spinner .. 를 씀
                this,android.R.layout.simple_spinner_item, items
                );

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, items2
        );

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items3
        );

        // 미리 정의된 레이아웃 사용
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);

        // 스피너 객체에다가 어댑터를 넣어줌
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택되면
                textView.setText("시간대 : "+items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 아무것도 선택되지 않은 상태일때
                textView.setText("선택 : ");
            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택되면
                textView2.setText("전체 출역 인원 : "+items2[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 아무것도 선택되지 않은 상태일때
                textView2.setText("선택 : ");
            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택되면
                textView3.setText("고령자 출역 인원 : "+items2[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // 아무것도 선택되지 않은 상태일때
                textView3.setText("선택 : ");
            }
        });

    }


}