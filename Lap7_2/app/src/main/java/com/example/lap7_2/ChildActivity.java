package com.example.lap7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class ChildActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Button btnBack=findViewById(R.id.btnBack);
        giaiPhuongTrinh();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }
    public void giaiPhuongTrinh(){
        // gọi inten
        Intent callIntent=getIntent();
        //lấy bundle ra
        Bundle bundleCall=callIntent.getBundleExtra("MyBundle");
        //truyền giá trị
        int soA=bundleCall.getInt("soA");
        int soB=bundleCall.getInt("soB");
        giaiPT(soA,soB);



    }
    public void openMainActivity(){
        Intent childIntent=new Intent(ChildActivity.this,MainActivity.class);
        startActivity(childIntent);
    }
    public void giaiPT(int a, int b){
        TextView txtKetQua=findViewById(R.id.txtKetQua);
        String kq="";
        if(a==0 && b==0){
            kq="Vô số nghiệm";

        }else if(a==0 && b!=0){
            kq="Vô nghiệm";
        }else {
            DecimalFormat dcf=new DecimalFormat("0.##");
            kq=dcf.format(-b*1.0/a);
        }
        txtKetQua.setText(kq);
    }
}
