package com.example.baocaoar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class settingString extends AppCompatActivity {
    private ImageView imgViet;
    private ImageView imgMy;
    private Locale myLocale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        imgViet = (ImageView) findViewById(R.id.imgViet);
        imgMy = (ImageView) findViewById(R.id.imgMy);
        imgViet.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                myLocale =new Locale("vi");
                doiNgonNgu(myLocale);
            }
        });
        imgMy.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                myLocale =new Locale("ja");
                doiNgonNgu(myLocale);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public  void doiNgonNgu(Locale locale){
        //doi tuong luu thong tin kich thuoc trinh bay
        DisplayMetrics displayMetrics =getBaseContext().getResources().getDisplayMetrics();

        //đối tượng cấu hình
        Configuration configuration=new Configuration();
        configuration.setLocale(locale);

        //cài đặt ngôn ngũ
        getBaseContext().getResources().updateConfiguration(configuration,displayMetrics);

        Intent refest=new Intent(settingString.this,settingString.class);
        Intent refest2=new Intent(settingString.this,dimen.class);
        Intent refest3=new Intent(settingString.this,MainActivity.class);

        startActivity(refest);startActivity(refest2);startActivity(refest3);
        finish();

    }
}
