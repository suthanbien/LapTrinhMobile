package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Button btnOpenMain=findViewById(R.id.btnOpenMain);
        btnOpenMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            doOpenMainActivity();
            }
        });
    }

    public void doOpenMainActivity(){
        Intent myInten = new Intent(ChildActivity.this,MainActivity.class);
        startActivity(myInten);
    }
}
