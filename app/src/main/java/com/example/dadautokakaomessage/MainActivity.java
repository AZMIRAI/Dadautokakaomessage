package com.example.dadautokakaomessage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.time.LocalDate;

public class MainActivity extends AppCompatActivity {





    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "" +
                "0. 일시 :  2021. *.*.* * CBM\n" +
                "1. Cell짱 : ***\n" +
                "2. 업체명 : \n" +
                "- **건설 (**,**,**)\n" +
                "*명\n" +
                "3. 고령자 출역인원 : \n" +
                "- *명\n" +
                "4. 출역 고령자 건강상태 : \n" +
                "- *\n" +
                "5. 작업내용 : \n" +
                "- 각 동 * * *\n" +
                "6. 위험성평가 위험작업 :\n" +
                "- 작업중 개인보호구 착용 철저\n" +
                "7. 사고사례전파내용 :\n" +
                "- 전기 공도구 감전 주의\n");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}