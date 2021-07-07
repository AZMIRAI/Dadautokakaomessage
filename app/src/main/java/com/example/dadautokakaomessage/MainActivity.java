/*
    0. 일시 :  2021. 07.03.토 $시간대 CBM
    1. Cell짱 : ###
    2. 업체명 :
    - ##건설 (#,#,#)
    $전체인원 명
    3. 고령자 출역인원 :
    - $고령자인원 명
    4. 출역 고령자 건강상태 :
    - 건강상태양호
    5. 작업내용 :
    - 각 동 # # #
    6. 위험성평가 위험작업 :
    - 작업중 개인보호구 착용 철저
    7. 사고사례전파내용 :
    - 전기 공도구 감전 주의
 */

package com.example.dadautokakaomessage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {



TextView textView,textView2,textView3;
Button send;


// 데이터를 배열에 넣어서 준비
    String[] items = {"오전","오후"};

    String[] items2 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

    String[] items3 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};

    String time;
    String people1, people2;
    String text="";


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
        send = (Button) findViewById(R.id.send);

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




        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 보내기 버튼을 누르면
                // 해당 spinner에 있는 값들이 아래 변수들로 저장
                time = spinner.getSelectedItem().toString();
                people1 = spinner2.getSelectedItem().toString();
                people2 = spinner3.getSelectedItem().toString();


                // text 문자열에 보낼 문자열 저장
                text += "0. 일시 :  2021. 07.03.토 "+ time +" CBM\n";
                text += "1. Cell짱 : ###\n";
                text += "2. 업체명 :\n";
                text += "- ##건설 (#,#,#)\n";
                text += people1 + "명\n";
                text += "3. 고령자 출역인원 :\n";
                text += people2 + "명\n";
                text += "4. 출역 고령자 건강상태 :\n" +
                        "    - 건강상태양호\n" +
                        "    5. 작업내용 :\n" +
                        "    - 각 동 # # #\n" +
                        "    6. 위험성평가 위험작업 :\n" +
                        "    - 작업중 개인보호구 착용 철저\n" +
                        "    7. 사고사례전파내용 :\n" +
                        "    - 전기 공도구 감전 주의";


                Intent Sharing_intent = new Intent(Intent.ACTION_SEND);
                Sharing_intent.setType("text/plain");

                String Test_Message = text;

                Sharing_intent.putExtra(Intent.EXTRA_TEXT, Test_Message);

                Intent Sharing = Intent.createChooser(Sharing_intent, "공유하기");
                startActivity(Sharing);

                // 제대로 가는지 문장 한번 출력
                System.out.println(text);
            }
        });

    }


}