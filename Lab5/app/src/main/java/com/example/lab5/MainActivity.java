package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCong = findViewById(R.id.button_cong);
        Button btnTru = findViewById(R.id.button_tru);
        Button btnNhan = findViewById(R.id.button_nhan);
        Button btnChia = findViewById(R.id.button_chia);
        final EditText txtSoA =  findViewById(R.id.editText_soa);
        final EditText txtSoB = findViewById(R.id.editText_sob);
        final TextView txtKetQua = findViewById(R.id.textView_KetQua);
        // sử lý biến cố click của từng cái
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int soA= Integer.parseInt(txtSoA.getText().toString());
                int soB = Integer.parseInt(txtSoB.getText().toString());
                int tong=soA+soB;

                txtKetQua.setText(soA +" + "+ soB+" = "+tong);


            }

        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soA = Integer.parseInt(txtSoA.getText().toString());
                int soB = Integer.parseInt(txtSoB.getText().toString());
                int hieu = soA - soB;
                txtKetQua.setText(soA +" - " +soB+ " = "+hieu);

            }
        });
        btnNhan.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soA = Integer.parseInt(txtSoA.getText().toString());
                int soB = Integer.parseInt(txtSoB.getText().toString());
                int tich = soA * soB;
                txtKetQua.setText(soA +" * " +soB+ " = "+tich);
            }
        }));
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soA = Integer.parseInt(txtSoA.getText().toString());
                int soB = Integer.parseInt(txtSoB.getText().toString());
                int thuong = soA / soB;
                txtKetQua.setText(soA +" / " +soB+ " = "+thuong);
            }
        });



    }
}
