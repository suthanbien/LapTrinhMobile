package com.example.lap7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenChild= findViewById(R.id.btnOpenChild);
        btnOpenChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            doOpenChildActivity();
            }
        });
    }
    public void doOpenChildActivity(){
        Intent myMainInten=new Intent(MainActivity.this, ChildActivity.class);
        
        startActivity(myMainInten);
    }

}
