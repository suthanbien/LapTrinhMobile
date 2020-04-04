package com.example.lap7_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnKetQua=findViewById(R.id.btnKetQua);
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChildActivity();
            }
        });
    }

    public void openChildActivity(){
        EditText txtSoA=findViewById(R.id.txtA);
        EditText txtSoB=findViewById(R.id.txtB);
        int a=Integer.parseInt(txtSoA.getText().toString().trim());
        int b=Integer.parseInt(txtSoB.getText().toString().trim());
        Intent myInten=new Intent(MainActivity.this,ChildActivity.class);
        Bundle myBundle=new Bundle();
        myBundle.putInt("soA",a);
        myBundle.putInt("soB",b);
        myInten.putExtra("MyBundle",myBundle);
        startActivity(myInten);

    }


}
