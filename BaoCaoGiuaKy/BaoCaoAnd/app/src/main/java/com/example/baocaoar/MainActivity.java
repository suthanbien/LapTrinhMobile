package com.example.baocaoar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private Button btnAchi;
    private Button btnPlay;
    private Button btnSetting;
    private ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        btnAchi = (Button) findViewById(R.id.btnAchi);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnSetting = (Button) findViewById(R.id.btnSetting);
        imgIcon = (ImageView) findViewById(R.id.imgIcon);

        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khởi tạo Resources
                Resources res =getResources();
                //tạo 1 biến color kiểu int
                int color =res.getColor(R.color.colorTextButton2);
                btnSetting.setTextColor(color);
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent:
                // (Mang nội dung sẽ gửi tới Example1Activity).
                Intent myIntent = new Intent(MainActivity.this, dimen.class);

                MainActivity.this.startActivity(myIntent);

            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo một Intent:
                // (Mang nội dung sẽ gửi tới Example1Activity).
                Intent myIntent = new Intent(MainActivity.this, settingString.class);

                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
